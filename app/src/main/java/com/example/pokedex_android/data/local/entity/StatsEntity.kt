package com.example.pokedex_android.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stats_table")
data class StatsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val baseStat: Int,
    val effort: Int,
    val name: String,
    val url: String
)
