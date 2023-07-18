package com.example.pokedex_android.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class PokemonWithStats(
    @Embedded
    val pokemonEntity: PokemonEntity,

    @Relation(
        parentColumn = "stats",
        entityColumn = "id"
    )
    val statsEntity: StatsEntity
)
