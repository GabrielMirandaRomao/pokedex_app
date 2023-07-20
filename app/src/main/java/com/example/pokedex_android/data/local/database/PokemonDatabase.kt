package com.example.pokedex_android.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.pokedex_android.data.local.entities.AbilitiesEntity
import com.example.pokedex_android.data.local.entities.PokemonEntity
import com.example.pokedex_android.data.local.entities.SpritesEntity
import com.example.pokedex_android.data.local.entities.StatsEntity
import com.example.pokedex_android.data.local.entities.TypesEntity
import com.example.pokedex_android.util.Constants.Companion.POKEMON_DATABASE

@Database(entities = [PokemonEntity::class], version = 1, exportSchema = false)
@TypeConverters(PokemonConverter::class)
abstract class PokemonDatabase: RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao

//    companion object {
//
//        private lateinit var db: PokemonDatabase
//
//        fun getDatabase(context: Context): PokemonDatabase {
//            if (Companion::db.isInitialized) return db
//
//            synchronized(PokemonDatabase::class) {
//                db = Room.databaseBuilder(
//                    context,
//                    PokemonDatabase::class.java,
//                    POKEMON_DATABASE
//                )
//                    .allowMainThreadQueries()
//                    .build()
//            }
//
//            return db
//        }
//
//    }
}