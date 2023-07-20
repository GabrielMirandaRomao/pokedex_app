package com.example.pokedex_android.repository

import com.example.pokedex_android.data.remote.models.pokemonModel.CompletePokemonResponse
import com.example.pokedex_android.data.remote.service.RetrofitInstance
import com.example.pokedex_android.data.remote.models.pokemonDevModel.PokedevResponse
import retrofit2.Response

class PokemonRepository {

    suspend fun getAllPokemons(): List<Response<CompletePokemonResponse>> {
        val pokemonList: List<Response<CompletePokemonResponse>> =
            RetrofitInstance.api.getAllPokemons().body()?.pokemonResponse!!.map {
                getPokemon(it.name)
            }

        return pokemonList
    }

    suspend fun getPokemon(name: String): Response<CompletePokemonResponse> {
        return RetrofitInstance.api.getPokemon(name)
    }

    suspend fun getPokemonDev(name: String): Response<PokedevResponse> {
        return RetrofitInstance.apiTwo.getPokeonInPokedev(name)
    }
}