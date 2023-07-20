package com.example.pokedex_android.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "abilities_table")
data class AbilitiesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val url: String
)

