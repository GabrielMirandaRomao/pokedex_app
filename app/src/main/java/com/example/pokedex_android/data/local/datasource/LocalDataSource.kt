package com.example.pokedex_android.data.local.datasource

import androidx.lifecycle.LiveData
import com.example.pokedex_android.data.local.database.PokemonDao
import com.example.pokedex_android.data.local.entities.PokemonEntity

class LocalDataSource(private val pokemonDao: PokemonDao) {

    val getAllPokemon: LiveData<List<PokemonEntity>> = pokemonDao.getAllPokemonsEntities()

    suspend fun addPokemon(pokemon: List<PokemonEntity>){
        pokemonDao.insertPokemon(pokemon)
    }
}