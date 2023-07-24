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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemon: List<PokemonEntity>)

    @Query("SELECT * FROM POKEMON_TABLE ORDER BY number ASC")
    fun getAllLocalPokemon(): List<PokemonEntity>

    @Query("DELETE FROM POKEMON_TABLE")
    fun deleteAllLocalPokemon()

    @Query("SELECT * FROM POKEMON_TABLE WHERE name LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): LiveData<List<PokemonEntity>>

    @Query("UPDATE POKEMON_TABLE SET isFavorite = :isFavorite  WHERE number == :number")
    fun updateFavoritePokemon(isFavorite: Int, number: Int)

    @Query("SELECT * FROM pokemon_table WHERE isFavorite == 1")
    fun getAllFavoritePokemon(): LiveData<List<PokemonEntity>>
}