package com.example.pokedex_android.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokedex_android.util.Constants.Companion.POKEMON_TABLE

@Entity(tableName = POKEMON_TABLE)
data class PokemonEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val abilities: String,
    val weight: Int,
    val height: Int,
    val name: String,
    val stats: String,
    val types: String,
    val sprites: String,
    val species: String
)