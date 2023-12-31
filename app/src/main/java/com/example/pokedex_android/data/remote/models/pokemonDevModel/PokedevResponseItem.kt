package com.example.pokedex_android.data.remote.models.pokemonDevModel

data class PokedevResponseItem(
    val abilities: AbilitiesDevResponse,
    val description: String,
    val eggGroups: List<String>,
    val family: FamilyResponse,
    val gen: Int,
    val gender: List<Double>,
    val height: String,
    val legendary: Boolean,
    val mega: Boolean,
    val mythical: Boolean,
    val name: String,
    val number: String,
    val species: String,
    val sprite: String,
    val starter: Boolean,
    val types: List<String>,
    val ultraBeast: Boolean,
    val weight: String
)