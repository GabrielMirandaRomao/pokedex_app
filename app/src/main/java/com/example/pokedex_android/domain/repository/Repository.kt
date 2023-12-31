package com.example.pokedex_android.domain.repository

import androidx.lifecycle.LiveData
import com.example.pokedex_android.data.remote.models.pokemonDevModel.PokedevResponse
import com.example.pokedex_android.data.remote.models.pokemonModel.CompletePokemonResponse
import com.example.pokedex_android.domain.model.Pokemon

interface Repository {
    suspend fun getAllPokemon(): List<Pokemon>
    suspend fun getPokemon(name: String): CompletePokemonResponse
    suspend fun insertPokemon(pokemon: List<Pokemon>)
    fun searchPokemon(pokemon: String): LiveData<List<Pokemon>>
    fun getAllFavoritePokemon(): LiveData<List<Pokemon>>
    fun updateFavoritePokemon(isFavorite: Int, number: Int)
    suspend fun getPokemonDev(name: String): PokedevResponse
    suspend fun getPokemonEvolutionLine(name: String): List<Pokemon>
}