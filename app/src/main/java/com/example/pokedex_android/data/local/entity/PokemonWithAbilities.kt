package com.example.pokedex_android.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class PokemonWithAbilities(
    @Embedded
    val pokemonEntity: PokemonEntity,

    @Relation(
        parentColumn = "abilities",
        entityColumn = "id"
    )
    val abilitiesEntity: AbilitiesEntity
)
