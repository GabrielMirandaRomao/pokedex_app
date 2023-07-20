package com.example.pokedex_android.data.remote.models.pokemonModel

import com.example.pokedex_android.data.remote.models.pokemonModel.OfficialArtworkResponse
import com.google.gson.annotations.SerializedName

data class OtherResponse(
    @SerializedName("official-artwork")
    val officialArt: OfficialArtworkResponse
)
