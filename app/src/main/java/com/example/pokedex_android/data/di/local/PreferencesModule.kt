package com.example.pokedex_android.data.di.local

import android.content.Context
import com.example.pokedex_android.data.di.repository.UserPreferencesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferencesModule {

    @Provides
    @Singleton
    fun providesDataStorePreferences(@ApplicationContext context: Context) =
        UserPreferencesRepository(context)
}