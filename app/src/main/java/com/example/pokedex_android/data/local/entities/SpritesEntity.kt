package com.example.pokedex_android.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sprites_table")
data class SpritesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val frontDefault: String,
    val frontShiny: String
)
