package com.example.pokedex_android.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.pokedex_android.data.local.datasource.LocalDataSource
import com.example.pokedex_android.data.local.entities.PokemonEntity
import com.example.pokedex_android.data.local.entities.toDomain
import com.example.pokedex_android.data.local.entities.toEntity
import com.example.pokedex_android.data.remote.datasource.RemoteDatasource
import com.example.pokedex_android.data.remote.models.pokemonModel.CompletePokemonResponse
import com.example.pokedex_android.data.remote.models.pokemonModel.toDomain
import com.example.pokedex_android.domain.model.Pokemon
import com.example.pokedex_android.domain.repository.Repository
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
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
        return if (localPokemon.isNullOrEmpty()) {
            getRemotePokemon()
        } else {
            localPokemon.map { it.toDomain() }
        }
    }

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
