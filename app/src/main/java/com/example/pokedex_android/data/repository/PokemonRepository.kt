package com.example.pokedex_android.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.pokedex_android.data.local.datasource.LocalDataSource
import com.example.pokedex_android.data.local.entities.PokemonEntity
import com.example.pokedex_android.data.local.entities.toDomain
import com.example.pokedex_android.data.local.entities.toEntity
import com.example.pokedex_android.data.remote.datasource.RemoteDatasource
import com.example.pokedex_android.data.remote.models.pokemonDevModel.PokedevResponse
import com.example.pokedex_android.data.remote.models.pokemonModel.CompletePokemonResponse
import com.example.pokedex_android.data.remote.models.pokemonModel.toDomain
import com.example.pokedex_android.domain.model.Pokemon
import com.example.pokedex_android.domain.repository.Repository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import retrofit2.Response
import java.util.Locale
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val remoteDatasource: RemoteDatasource,
    private val localDataSource: LocalDataSource
) : Repository {

    // Sempre deve vir do banco
    // Dar um request na api, popular o banco e em seguida a viewmodel recebe apenas do banco
    // Verificar o tamanho do banco, comparar com
    // if next != null
    // chamar a url -> lista

    override suspend fun getAllPokemon(): List<Pokemon> {
        val localPokemon = localDataSource.getAllLocalPokemon()
        return if (localPokemon.isEmpty()) {
            getRemotePokemon()
        } else {
            localPokemon.map { it.toDomain() }
        }
    }

    override suspend fun getPokemonDev(name: String): PokedevResponse {
        val response = when (name.lowercase()) {
            "nidoran-f" -> remoteDatasource.getPokemonDev("Nidoran\u2640")
            "nidoran-m" -> remoteDatasource.getPokemonDev("Nidoran\u2642")
            else -> remoteDatasource.getPokemonDev(name)
        }

        if (response.isSuccessful.not()) {
            throw PokemonFetchException("Unable to fetch Pokemon details from remote source")
        }

        return response.body()
            ?: throw PokemonFetchException("Received null Pokemon details from remote source")
    }

    override suspend fun getPokemonEvolutionLine(name: String): List<Pokemon> {
        val pokemonList = mutableListOf<Pokemon>()

        try {
            val response: Response<PokedevResponse> = when (name) {
                "nidoran-f" -> remoteDatasource.getPokemonDev("nidoran\u2640")
                "nidoran-m" -> remoteDatasource.getPokemonDev("nidoran\u2642")
                else -> remoteDatasource.getPokemonDev(name)
            }

            if (response.isSuccessful.not()) {
                throw PokemonFetchException("Unable to fetch Pokemon details from the remote source")
            }

            if (name == "eevee") {
                val evolutionLine: String = "eevee/" + response.body()!![0].family.evolutionLine[1]

                val evolutions = evolutionLine.split("/")
                for (evolutionName in evolutions) {
                    val pokemonName = evolutionName.lowercase(Locale.ROOT)
                    val pokemonData = localDataSource.getPokemonEvolution(
                        pokemonName
                    )?.toDomain()
                    if (pokemonData != null) {
                        pokemonList.add(pokemonData)
                    }
                }
            } else {
                val evolutionLine = response.body()?.get(0)?.family?.evolutionLine
                if (!evolutionLine.isNullOrEmpty()) {
                    for (pokemon in evolutionLine) {
                        val pokemonData = when (pokemon.lowercase(Locale.ROOT)) {
                            "nidoran♀" -> localDataSource.getPokemonEvolution("nidoran-f")
                                .toDomain()

                            "nidoran♂" -> localDataSource.getPokemonEvolution("nidoran-m")
                                .toDomain()

                            else -> localDataSource.getPokemonEvolution(pokemon.lowercase(Locale.ROOT))
                                .toDomain()
                        }
                        if (pokemonData != null) {
                            pokemonList.add(pokemonData)
                        }
                    }
                }
            }

            return pokemonList

        } catch (ex: PokemonFetchException) {
            throw PokemonFetchException("An error occurred while fetching Pokemon evolution tree")
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private suspend fun getRemotePokemon(): List<Pokemon> {
        val concurrencyLimit = 2
        val response = remoteDatasource.getAllPokemon()

        if (response.isSuccessful.not()) {
            throw PokemonFetchException("Unable to fetch Pokemon from remote source")
        }

        val pokemonNames = response.body()?.pokemonResponse?.map { it.name } ?: emptyList()

        val remotePokemon = pokemonNames.asFlow().flatMapMerge(concurrencyLimit) { name ->
            flow {
                emit(getPokemon(name).toDomain())
            }
        }.toList()

        val localData = localDataSource.getAllLocalPokemon()

        if (!areListsEqual(remotePokemon, localData)) {
            localDataSource.deletePokemon()
            localDataSource.insertPokemon(remotePokemon.map { it.toEntity() })
        }

        return localDataSource.getAllLocalPokemon().map { it.toDomain() }
    }

    override fun getAllFavoritePokemon(): LiveData<List<Pokemon>> {
        return localDataSource.getAllFovoritePokemon().map { list -> list.map { it.toDomain() } }
    }

    override fun updateFavoritePokemon(isFavorite: Int, number: Int) {
        localDataSource.updateTofavorite(isFavorite, number)
    }

    private fun areListsEqual(listLocal: List<Pokemon>, listRemote: List<PokemonEntity>): Boolean {
        return listLocal.size == listRemote.size && listLocal.all { listRemote.contains(it.toEntity()) }
    }

    override suspend fun getPokemon(name: String): CompletePokemonResponse {
        val response = remoteDatasource.getPokemon(name)

        if (response.isSuccessful.not()) {
            throw PokemonFetchException("Unable to fetch Pokemon details from remote source")
        }

        return response.body()
            ?: throw PokemonFetchException("Received null Pokemon details from remote source")
    }

    override suspend fun insertPokemon(pokemon: List<Pokemon>) {
        localDataSource.insertPokemon(pokemon.map { it.toEntity() })
    }

    override fun searchPokemon(pokemon: String): LiveData<List<Pokemon>> {
        return localDataSource.searchPokemon(pokemon).map { list -> list.map { it.toDomain() } }
    }
}

class PokemonFetchException(message: String) : Exception(message)

