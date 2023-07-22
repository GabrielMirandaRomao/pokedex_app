package com.example.pokedex_android.domain.usecase

import android.os.RemoteException
import com.example.pokedex_android.data.remote.models.pokemonDevModel.PokedevResponse
import com.example.pokedex_android.domain.repository.Repository
import javax.inject.Inject

class GetAllPokemonDevUseCase @Inject constructor(
    private val repository: Repository
) {

//    suspend operator fun invoke() : Result<PokedevResponse> {
//        return try {
//            Result.success(repository.getPokemonDev())
//        }catch (exception: RemoteException){
//            Result.failure(exception)
//        }
//    }
}