package com.example.pokedex_android.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

data class SpeciesEntity(
    val name: String,
    val url: String
)
