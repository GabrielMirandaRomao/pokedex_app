package com.example.pokedex_android.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

data class StatsEntity(
    val baseStat: Int,
    val effort: Int
)
