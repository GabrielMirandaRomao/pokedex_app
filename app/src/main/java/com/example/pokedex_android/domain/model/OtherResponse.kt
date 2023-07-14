package com.example.pokedex_android.domain.model

import com.google.gson.annotations.SerializedName

data class OtherResponse(
    @SerializedName("official-artwork")
    val officialArt: OfficialArtworkResponse
)
