package com.example.pokedex_android.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pokedex_android.data.local.entity.AbilitiesEntity
import com.example.pokedex_android.data.local.entity.PokemonEntity
import com.example.pokedex_android.data.local.entity.SpritesEntity
import com.example.pokedex_android.data.local.entity.StatsEntity
import com.example.pokedex_android.data.local.entity.TypesEntity
import com.example.pokedex_android.util.Constants.Companion.POKEMON_DATABASE

@Database(entities = [PokemonEntity::class, AbilitiesEntity::class, StatsEntity::class,
    TypesEntity::class, SpritesEntity::class], version = 1, exportSchema = false)
abstract class PokemonDatabase: RoomDatabase() {

    abstract val pokemonDao: PokemonDao
    abstract fun abilitiesDao(): AbilitiesDao
    abstract fun statsDao(): StatsDao
    abstract fun typesDao(): TypesDao
    abstract fun spritesDao(): SpritesDao
    abstract fun speciesDao(): SpeciesDao

    companion object {

        private lateinit var db: PokemonDatabase

        @Volatile
        private var INSTANCE: PokemonDatabase? = null

        fun getDatabase(context: Context): PokemonDatabase {
            if (::db.isInitialized) return db

            synchronized(PokemonDatabase::class) {
                db = Room.databaseBuilder(
                    context,
                    PokemonDatabase::class.java,
                    POKEMON_DATABASE
                )
                    .allowMainThreadQueries()
                    .build()
            }

            return db
        }

    }
}