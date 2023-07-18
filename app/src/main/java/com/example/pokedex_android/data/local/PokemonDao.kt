package com.example.pokedex_android.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.pokedex_android.data.local.entity.AbilitiesEntity
import com.example.pokedex_android.data.local.entity.PokemonEntity
import com.example.pokedex_android.data.local.entity.PokemonWithAbilities

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPokemon(pokemon: List<PokemonEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAbilities(abilities: List<AbilitiesEntity>)

    @Query("SELECT * FROM POKEMON_TABLE")
    fun getAllPokemonsEntities(): LiveData<List<PokemonEntity>>

    @Transaction
    @Query("SELECT * FROM POKEMON_TABLE")
    fun getAllPokemonWithAbilities(): LiveData<List<PokemonWithAbilities>>

}