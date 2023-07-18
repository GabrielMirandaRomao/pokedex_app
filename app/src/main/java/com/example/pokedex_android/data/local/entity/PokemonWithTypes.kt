package com.example.pokedex_android.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class PokemonWithTypes(
    @Embedded
    val pokemonEntity: PokemonEntity,

    @Relation(
        parentColumn = "types",
        entityColumn = "id"
    )
    val typesEntity: TypesEntity
)
