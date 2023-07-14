package com.example.pokedex_android.domain.model

import com.google.gson.annotations.SerializedName

data class TypesResponse(
    @SerializedName("slot")
    val slot: Int,
    @SerializedName("type")
    val type: PokemonTypeResponse
)
