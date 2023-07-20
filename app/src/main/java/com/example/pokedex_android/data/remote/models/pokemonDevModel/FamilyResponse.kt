package com.example.pokedex_android.data.remote.models.pokemonDevModel

data class FamilyResponse(
    val evolutionLine: List<String>,
    val evolutionStage: Int,
    val id: Int
)