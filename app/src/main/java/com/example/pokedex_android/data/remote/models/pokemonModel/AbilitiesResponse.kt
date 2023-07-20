package com.example.pokedex_android.data.remote.models.pokemonModel

import com.google.gson.annotations.SerializedName

data class AbilitiesResponse(
    @SerializedName("ability")
    val abilityResponse: AbilityResponse,
    @SerializedName("slot")
    val slot: Int
)