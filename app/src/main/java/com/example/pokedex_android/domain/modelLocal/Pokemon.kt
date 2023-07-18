//package com.example.pokedex_android.domain.modelLocal
//
//import android.os.Parcelable
//import androidx.room.PrimaryKey
//import com.example.pokedex_android.domain.modelLocal.Stats
//import com.example.pokedex_android.domain.modelLocal.Types
//import kotlinx.parcelize.Parcelize
//import kotlinx.parcelize.RawValue
//
//@Parcelize
//data class Pokemon(
//
//    @PrimaryKey(autoGenerate = false)
//    val id: Int,
//    val abilities: @RawValue List<Abilities>?,
//    val weight: Int?,
//    val height: Int?,
//    val name: String,
//    val stats: @RawValue List<Stats>?,
//    val types: @RawValue List<Types>,
//    val sprites: @RawValue List<Sprites>,
//    val species: @RawValue Species?
//): Parcelable
//
//
