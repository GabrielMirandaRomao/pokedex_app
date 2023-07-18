package com.example.pokedex_android.data.local.repository

import androidx.lifecycle.LiveData
import com.example.pokedex_android.data.local.PokemonDao
import com.example.pokedex_android.data.local.entity.AbilitiesEntity
import com.example.pokedex_android.data.local.entity.PokemonEntity

class PokemonLocalRepository(private val pokemonDao: PokemonDao) {

    val getAllPokemon: LiveData<List<PokemonEntity>> = pokemonDao.getAllPokemonsEntities()

    suspend fun addPokemon(pokemon: List<PokemonEntity>){
        pokemonDao.insertPokemon(pokemon)
    }

    suspend fun addPokemonAbilities(abilities: List<AbilitiesEntity>) {
        pokemonDao.insertAbilities(abilities)
    }
}