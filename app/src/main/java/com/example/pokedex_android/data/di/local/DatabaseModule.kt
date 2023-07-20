package com.example.pokedex_android.data.di.local

import android.content.Context
import androidx.room.Room
import com.example.pokedex_android.data.local.database.PokemonDao
import com.example.pokedex_android.data.local.database.PokemonDatabase
import com.example.pokedex_android.util.Constants.Companion.POKEMON_DATABASE
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Provides
    @Singleton
    fun providesDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, PokemonDatabase::class.java, POKEMON_DATABASE)
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun providesDao(database: PokemonDatabase) : PokemonDao {
        return database.pokemonDao()
    }

}