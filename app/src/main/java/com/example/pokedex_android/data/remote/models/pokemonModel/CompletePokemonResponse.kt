package com.example.pokedex_android.data.remote.models.pokemonModel

import com.example.pokedex_android.domain.model.Abilities
import com.example.pokedex_android.domain.model.Pokemon
import com.example.pokedex_android.domain.model.Species
import com.example.pokedex_android.domain.model.Stats
import com.example.pokedex_android.domain.model.Types
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CompletePokemonResponse(
    @SerializedName("abilities")
    val abilities: List<AbilitiesResponse>?,
    @SerializedName("base_experience")
    val baseExperience: Int?,
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

fun CompletePokemonResponse.toDomain(): Pokemon {
    return Pokemon(
        abilities = this.abilities?.map {
            Abilities(
                slot = it.slot,
                name = it.abilityResponse.name,
                url = it.abilityResponse.url
            )
        },
        baseExperience = this.baseExperience,
        weight = this.weight,
        height = this.height,
        number = this.id,
        name = this.name,
        stats = this.stats?.map {
            Stats(
                baseStat = it.baseStat,
                effort = it.effort
            )
        },
        types = this.types.map {
            Types(
                slot = it.slot,
                name = it.type.name
            )
        },
        imageUrl = this.spritesResponse?.other?.officialArt?.frontDefault,
        secondImageUrl = this.spritesResponse?.other?.officialArt?.frontShiny,
        speciesResponse = Species(
            name = this.speciesResponse.name,
            url = this.speciesResponse.url
        )
    )
}


