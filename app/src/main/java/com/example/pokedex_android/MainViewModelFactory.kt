package com.example.pokedex_android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokedex_android.repository.PokemonRepository

class MainViewModelFactory(
    private val pokemonRepository: PokemonRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel() as T
    }
}