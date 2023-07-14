package com.example.pokedex_android.data.remote.service

import com.example.pokedex_android.domain.model.AllPokemonResponse
import com.example.pokedex_android.domain.model.OnePokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IPokemonApiService {

    @GET("pokemon?limit=151")
    suspend fun getAllPokemons(
    ): Response<AllPokemonResponse>

    @GET("pokemon/{name}")
    suspend fun getPokemon(
        @Path("name") name : String
    ) : Response<OnePokemonResponse>
}