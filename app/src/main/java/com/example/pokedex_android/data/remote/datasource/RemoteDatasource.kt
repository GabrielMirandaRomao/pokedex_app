package com.example.pokedex_android.data.remote.datasource

import com.example.pokedex_android.data.remote.models.pokemonDevModel.PokedevResponse
import com.example.pokedex_android.data.remote.models.pokemonModel.AllPokemonResponse
import com.example.pokedex_android.data.remote.models.pokemonModel.CompletePokemonResponse
import com.example.pokedex_android.data.remote.service.IPokedevApiService
import com.example.pokedex_android.data.remote.service.IPokemonApiService
import retrofit2.Response
import javax.inject.Inject

class RemoteDatasource @Inject constructor(
    private val pokemonApiService: IPokemonApiService,
    private val pokedevApiService: IPokedevApiService
){
    suspend fun getAllPokemon(): Response<AllPokemonResponse> {
        return pokemonApiService.getAllPokemons()
    }

    suspend fun getPokemon(name: String): Response<CompletePokemonResponse> {
        return pokemonApiService.getPokemon(name)
    }

    suspend fun getPokemonDev(name: String): Response<PokedevResponse> {
        return pokedevApiService.getPokemonDev(name)
    }

}