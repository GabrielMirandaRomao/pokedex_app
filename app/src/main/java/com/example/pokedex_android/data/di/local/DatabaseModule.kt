package com.example.pokedex_android.data.di.local

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.pokedex_android.data.local.database.PokemonDao
import com.example.pokedex_android.data.local.database.PokemonDatabase
import com.example.pokedex_android.util.Constants.Companion.POKEMON_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

//    @VisibleForTesting
//    val MIGRATION_1_2 = object : Migration(1, 2) {
//        override fun migrate(database: SupportSQLiteDatabase) {
//
//        }
//    }

    @Provides
    @Singleton
    fun providesDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, PokemonDatabase::class.java, POKEMON_DATABASE)
        .fallbackToDestructiveMigration()
//        .addMigrations(MIGRATION_1_2)
        .allowMainThreadQueries()
        .build()

    @Provides
    @Singleton
    fun providesDao(database: PokemonDatabase): PokemonDao {
        return database.pokemonDao()
    }

}