package com.example.pokedex_android.domain.usecase

import androidx.lifecycle.LiveData
import com.example.pokedex_android.domain.model.Pokemon
import com.example.pokedex_android.domain.repository.Repository
import javax.inject.Inject

class GetAllFavoritePokemonUseCase @Inject constructor(
    private val repository: Repository
){

    fun getAllFavoritePokemon(): LiveData<List<Pokemon>> {
        return try {
            repository.getAllFavoritePokemon()
        } catch (exception: Exception) {
            throw exception
        }
    }

    fun updateFavoritePokemon(isFavorite: Int, number: Int) {
        try {
            repository.updateFavoritePokemon(isFavorite, number)
        } catch (exception: Exception) {
            throw exception
        }
    }
}