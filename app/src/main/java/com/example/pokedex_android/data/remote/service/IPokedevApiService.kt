package com.example.pokedex_android.data.remote.service

import com.example.pokedex_android.data.remote.models.pokemonDevModel.PokedevResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IPokedevApiService {

    @GET("pokemon/{name}")
    suspend fun getPokeonInPokedev(
        @Path("name") name : String
    ) : Response<PokedevResponse>
}