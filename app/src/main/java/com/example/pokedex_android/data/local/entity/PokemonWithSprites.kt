package com.example.pokedex_android.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class PokemonWithSprites(
    @Embedded
    val pokemonEntity: PokemonEntity,

    @Relation(
        parentColumn = "sprites",
        entityColumn = "id"
    )
    val spritesEntity: SpritesEntity
)
