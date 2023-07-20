package com.example.pokedex_android.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

data class AbilitiesEntity(
    val slot: Int,
    val name: String,
    val url: String
)

