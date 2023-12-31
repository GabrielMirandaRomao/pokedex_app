package com.example.pokedex_android.data.remote.models.pokemonModel

import com.google.gson.annotations.SerializedName

data class AllPokemonResponse (
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any?,
    @SerializedName("results")
    val pokemonResponse: List<PokemonModel>
)