package com.example.pokedex_android.domain.model

import com.google.gson.annotations.SerializedName

data class PokemonTypeResponse(
    @SerializedName("name")
    val name: String
)
