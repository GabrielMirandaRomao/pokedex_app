package com.example.pokedex_android.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class OnePokemonResponse(
    @SerializedName("abilities")
    val abilities: List<AbilitiesResponse>?,
    @SerializedName("weight")
    val weight: Int?,
    @SerializedName("height")
    val height: Int?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("stats")
    val stats: List<StatsResponse>?,
    @SerializedName("types")
    val types: List<TypesResponse>,
    @SerializedName("sprites")
    val spritesResponse: SpritesResponse?,
    @SerializedName("species")
    val speciesResponse: SpeciesResponse
) : Serializable
