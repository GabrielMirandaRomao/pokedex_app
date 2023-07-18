package com.example.pokedex_android.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class PokemonWithSpecies(
    @Embedded
    val pokemonEntity: PokemonEntity,

    @Relation(
        parentColumn = "species",
        entityColumn = "id"
    )
    val speciesEntity: SpeciesEntity
)
