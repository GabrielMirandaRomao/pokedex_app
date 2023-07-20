package com.example.pokedex_android.data.remote.models.pokemonModel

import com.example.pokedex_android.data.remote.models.pokemonModel.StatResponse
import com.google.gson.annotations.SerializedName

data class StatsResponse(
    @SerializedName("base_stat")
    val baseStat: Int,
    @SerializedName("effort")
    val effort: Int,
    @SerializedName("stat")
    val statResponse: StatResponse
)
