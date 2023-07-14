package com.example.pokedex_android.repository

import com.example.pokedex_android.data.remote.service.RetrofitInstance
import com.example.pokedex_android.domain.model.OnePokemonResponse
import com.example.pokedex_android.domain.modelPokedev.PokedevResponse
import retrofit2.Response


class PokemonRepository {

    suspend fun getAllPokemons(): List<Response<OnePokemonResponse>> {
        val pokemonList: List<Response<OnePokemonResponse>> =
            RetrofitInstance.api.getAllPokemons().body()?.pokemonResponse!!.map {
                getPokemon(it.name)
            }

        return pokemonList
    }

    suspend fun getPokemon(name: String): Response<OnePokemonResponse> {
        return RetrofitInstance.api.getPokemon(name)
    }

    suspend fun getPokemonDev(name: String): Response<PokedevResponse> {
        return RetrofitInstance.apiTwo.getPokeonInPokedev(name)
    }
}