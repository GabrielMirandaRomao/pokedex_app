package com.example.pokedex_android.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokedex_android.domain.model.Abilities
import com.example.pokedex_android.domain.model.Pokemon
import com.example.pokedex_android.domain.model.Species
import com.example.pokedex_android.domain.model.Stats
import com.example.pokedex_android.domain.model.Types
import com.example.pokedex_android.util.Constants.Companion.POKEMON_TABLE

@Entity(tableName = POKEMON_TABLE)
data class PokemonEntity(

    @PrimaryKey(autoGenerate = false)
    val number: Int,
    val abilities: List<AbilitiesEntity>?,
    val baseExperience: Int?,
    val weight: Int?,
    val height: Int?,
    val name: String,
    val stats: List<StatsEntity>?,
    val types: List<TypesEntity>,
    val imageUrl: String?,
    val secondImageUrl: String?,
    val speciesResponse: SpeciesEntity?,
    val isFavorite: Boolean
)

fun PokemonEntity.toDomain() = Pokemon(
    number= this.number,
    abilities = this.abilities?.map {
        Abilities(
            slot = it.slot,
            name = it.name,
            url = it.url
        )
    },
    baseExperience = this.baseExperience,
    weight = this.weight,
    height = this.height,
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
            name = it.name
        )
    },
    imageUrl = this.imageUrl,
    secondImageUrl = this.secondImageUrl,
    speciesResponse = this.speciesResponse?.let {
        Species(
            name = it.name,
            url = it.url
        )
    },
    isFavorite = false
)

fun Pokemon.toEntity() = PokemonEntity(
    number= this.number,
    abilities = this.abilities?.map {
        AbilitiesEntity(
            slot = it.slot,
            name = it.name,
            url = it.url
        )
    },
    baseExperience = this.baseExperience,
    weight = this.weight,
    height = this.height,
    name = this.name,
    stats = this.stats?.map {
        StatsEntity(
            baseStat = it.baseStat,
            effort = it.effort
        )
    },
    types = this.types.map {
        TypesEntity(
            slot = it.slot,
            name = it.name
        )
    },
    imageUrl = this.imageUrl,
    secondImageUrl = this.secondImageUrl,
    speciesResponse = this.speciesResponse?.let {
        SpeciesEntity(
            name = it.name,
            url = it.url
        )
    },
    isFavorite = false
)