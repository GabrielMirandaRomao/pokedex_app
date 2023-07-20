package com.example.pokedex_android.data.remote.datasource

import com.example.pokedex_android.data.remote.models.pokemonModel.AllPokemonResponse
import com.example.pokedex_android.data.remote.models.pokemonModel.CompletePokemonResponse
import com.example.pokedex_android.data.remote.service.RetrofitInstance
import retrofit2.Response

class RemoteDatasource {
    suspend fun getAllPokemon(): Response<AllPokemonResponse> {
        return RetrofitInstance.api.getAllPokemons()
    }

    suspend fun getPokemon(name: String): Response<CompletePokemonResponse> {
        return RetrofitInstance.api.getPokemon(name)
    }

}