package com.example.pokedex_android.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "species_table")
data class SpeciesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val url: String
)
