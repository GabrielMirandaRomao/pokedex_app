package com.example.pokedex_android.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

data class SpritesEntity(
    val id: Int,
    val frontDefault: String,
    val frontShiny: String
)
