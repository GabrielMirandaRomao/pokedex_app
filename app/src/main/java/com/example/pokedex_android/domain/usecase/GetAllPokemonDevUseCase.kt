package com.example.pokedex_android.domain.usecase

import android.os.RemoteException
import com.example.pokedex_android.data.remote.models.pokemonDevModel.PokedevResponse
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

    fun getPokemonImage(name: String): String {
        return try {
            repository.getPokemonImage(name)
        } catch (exception: RemoteException) {
            throw exception
        }
    }
}