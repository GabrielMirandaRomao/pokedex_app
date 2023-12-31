package com.example.pokedex_android.data.di.repository

import com.example.pokedex_android.data.local.datasource.LocalDataSource
import com.example.pokedex_android.data.remote.datasource.RemoteDatasource
import com.example.pokedex_android.data.repository.PokemonRepository
import com.example.pokedex_android.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesPokemonRepository(
        remoteDatasource: RemoteDatasource,
        localDataSource: LocalDataSource
    ): Repository {
        return PokemonRepository(remoteDatasource, localDataSource)
    }

}