package com.example.pokedex_android.data.remote.models.pokemonModel

import com.google.gson.annotations.SerializedName

data class SpeciesResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)
