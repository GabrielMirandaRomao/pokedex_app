package com.example.pokedex_android.data.local.datasource

import androidx.lifecycle.LiveData
import com.example.pokedex_android.data.local.database.PokemonDao
import com.example.pokedex_android.data.local.entities.PokemonEntity
import java.text.FieldPosition
import javax.inject.Inject

class LocalDataSource @Inject constructor (
    private val pokemonDao: PokemonDao
) {

    fun getAllLocalPokemon(): List<PokemonEntity>{
        return pokemonDao.getAllLocalPokemon()
    }

    suspend fun insertPokemon(pokemon: List<PokemonEntity>){
        pokemonDao.insertPokemon(pokemon)
    }

    fun deletePokemon(){
        pokemonDao.deleteAllLocalPokemon()
    }

    fun searchPokemon(pokemon: String) : LiveData<List<PokemonEntity>>{
        return pokemonDao.searchDatabase(pokemon)
    }

    fun getAllFovoritePokemon(): LiveData<List<PokemonEntity>> {
        return pokemonDao.getAllFavoritePokemon()
    }

    fun updateTofavorite(isFavorite: Int, number: Int) {
        pokemonDao.updateFavoritePokemon(isFavorite, number)
    }

    fun getPokemonImage(name: String): String {
        return pokemonDao.getPokemonImage(name)
    }
}