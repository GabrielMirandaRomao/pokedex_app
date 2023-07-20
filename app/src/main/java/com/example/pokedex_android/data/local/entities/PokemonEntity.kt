package com.example.pokedex_android.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokedex_android.util.Constants.Companion.POKEMON_TABLE

@Entity(tableName = POKEMON_TABLE)
data class PokemonEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val abilities: String,
    val weight: Int,
    val height: Int,
    val name: String,
    val stats: String,
    val types: String,
    val sprites: String,
    val species: String
)

//fun PokemonEntity.toDomain() = Pokemon(
//    id = this.id,
//    abilities = this.abilities?.map {
//        Abilities(
//            name = it.name,
//            url = it.url
//        )
//    },
//    weight = this.weight,
//    height = this.height,
//    name = this.name,
//    stats = this.stats?.map {
//        Stats(
//            baseStat = it.baseStat,
//            effort = it.effort
//        )
//    },
//    types = this.types.map {
//        Types(
//            name = it.name
//        )
//    },
//    sprites = this.sprites.map {
//        Sprites(
//            frontDefault = it.frontDefault,
//            frontShiny = it.frontShiny
//        )
//    },
//    species = this.species.let {
//        Species(
//            name = it!!.name,
//            url = it.url
//        )
//    }
//)
//
//fun Pokemon.toEntity() = PokemonEntity(
//    id = this.id,
//    abilities = this.abilities?.map {
//        AbilitiesEntity(
//            name = it.name,
//            url = it.url
//        )
//    },
//    weight = this.weight,
//    height = this.height,
//    name = this.name,
//    stats = this.stats!!.map {
//        StatsEntity(
//            baseStat = it.baseStat,
//            effort = it.effort
//        )
//    },
//    types = this.types.map {
//        TypesEntity(
//            name = it.name
//        )
//    },
//    sprites = this.sprites.map {
//        SpritesEntity(
//            frontDefault = it.frontDefault,
//            frontShiny = it.frontShiny
//        )
//    },
//    species = this.species.let {
//        SpeciesEntity(
//            name = it!!.name,
//            url = it.url
//        )
//    }
//)