package com.example.pokedex_android.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "types_table")
data class TypesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String
)
