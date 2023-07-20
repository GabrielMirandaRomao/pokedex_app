package com.example.pokedex_android.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

data class StatsEntity(
    val id: Int,
    val baseStat: Int,
    val effort: Int,
    val name: String,
    val url: String
)
