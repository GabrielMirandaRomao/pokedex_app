package com.example.pokedex_android.data.remote.datasource

import com.example.pokedex_android.data.remote.models.pokemonModel.AllPokemonResponse
import com.example.pokedex_android.data.remote.models.pokemonModel.CompletePokemonResponse
import com.example.pokedex_android.data.remote.service.IPokemonApiService
import com.example.pokedex_android.data.remote.service.RetrofitInstance
import retrofit2.Response
import javax.inject.Inject

class RemoteDatasource @Inject constructor(
    private val pokemonApiService: IPokemonApiService
){
    suspend fun getAllPokemon(): Response<AllPokemonResponse> {
        return pokemonApiService.getAllPokemons()
    }

    suspend fun getPokemon(name: String): Response<CompletePokemonResponse> {
        return pokemonApiService.getPokemon(name)
    }

}