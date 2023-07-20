package com.example.pokedex_android.data.local.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.pokedex_android.data.local.entities.AbilitiesEntity
import com.example.pokedex_android.data.local.entities.PokemonEntity

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPokemon(pokemon: List<PokemonEntity>)

    @Query("SELECT * FROM POKEMON_TABLE")
    fun getAllPokemonsEntities(): LiveData<List<PokemonEntity>>


}