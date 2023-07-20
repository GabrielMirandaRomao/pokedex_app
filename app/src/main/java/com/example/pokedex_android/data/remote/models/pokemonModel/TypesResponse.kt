package com.example.pokedex_android.data.remote.models.pokemonModel

import com.example.pokedex_android.data.remote.models.pokemonModel.PokemonTypeResponse
import com.google.gson.annotations.SerializedName

data class TypesResponse(
    @SerializedName("slot")
    val slot: Int,
    @SerializedName("type")
    val type: PokemonTypeResponse
)
