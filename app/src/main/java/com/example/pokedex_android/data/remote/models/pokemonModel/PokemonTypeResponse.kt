package com.example.pokedex_android.data.remote.models.pokemonModel

import com.google.gson.annotations.SerializedName

data class PokemonTypeResponse(
    @SerializedName("name")
    val name: String
)
