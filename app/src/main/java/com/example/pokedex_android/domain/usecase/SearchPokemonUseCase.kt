package com.example.pokedex_android.domain.usecase

import androidx.lifecycle.LiveData
import com.example.pokedex_android.domain.model.Pokemon
import com.example.pokedex_android.domain.repository.Repository
import javax.inject.Inject

class SearchPokemonUseCase @Inject constructor(
    private val repository: Repository
){

    fun searchPokemonFromDatabase(search: String) : LiveData<List<Pokemon>> {
        return try {
            repository.searchPokemon(search)
        }catch (exception: Exception){
            throw  exception
        }
    }
}