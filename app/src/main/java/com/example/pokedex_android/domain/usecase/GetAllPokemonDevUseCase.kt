package com.example.pokedex_android.domain.usecase

import android.os.RemoteException
import com.example.pokedex_android.data.remote.models.pokemonDevModel.PokedevResponse
import com.example.pokedex_android.domain.model.Pokemon
import com.example.pokedex_android.domain.repository.Repository
import javax.inject.Inject

class GetAllPokemonDevUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend fun getPokemonDev(name: String): PokedevResponse {
        return try {
            repository.getPokemonDev(name)
        } catch (exception: RemoteException) {
            throw exception
        }
    }

    suspend fun getPokemonEvolutionLine(name: String): List<Pokemon> {
        return try {
            repository.getPokemonEvolutionLine(name)
        } catch (exception: RemoteException) {
            throw exception
        }
    }
}