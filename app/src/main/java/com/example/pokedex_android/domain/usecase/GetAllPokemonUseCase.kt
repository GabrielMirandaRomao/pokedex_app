package com.example.pokedex_android.domain.usecase

import android.os.RemoteException
import com.example.pokedex_android.domain.model.Pokemon
import com.example.pokedex_android.domain.repository.Repository
import javax.inject.Inject

class GetAllPokemonUseCase @Inject constructor(
    private val repository: Repository
){

    suspend operator fun  invoke() : Result<List<Pokemon>> {
        return try {
            Result.success(repository.getAllPokemon())
        }catch (exception: RemoteException){
            Result.failure(exception)
        }
    }
}