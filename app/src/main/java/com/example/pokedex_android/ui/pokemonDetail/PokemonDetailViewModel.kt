package com.example.pokedex_android.ui.pokemonDetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex_android.data.remote.models.pokemonDevModel.PokedevResponse
import com.example.pokedex_android.domain.model.Pokemon
import com.example.pokedex_android.domain.usecase.GetAllFavoritePokemonUseCase
import com.example.pokedex_android.domain.usecase.GetAllPokemonDevUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getAllFavoritePokemonUseCase: GetAllFavoritePokemonUseCase,
    private val getAllPokemonDevUseCase: GetAllPokemonDevUseCase
) : ViewModel() {

    private var _pokemon = MutableLiveData<PokedevResponse>()
    val pokemon: LiveData<PokedevResponse> = _pokemon

    private var _pokemonEvolutionLine = MutableLiveData<List<Pokemon>>()
    val pokemonEvolutionLine: LiveData<List<Pokemon>> = _pokemonEvolutionLine


    fun updateFavoritePokemon(isFavorite: Int, number: Int) {
        getAllFavoritePokemonUseCase.updateFavoritePokemon(isFavorite, number)
    }

    fun getPokemonDev(name: String){
        viewModelScope.launch {
            _pokemon.value = getAllPokemonDevUseCase.getPokemonDev(name)
        }
    }

    fun getPokemonImage(name: String): String{
        return getAllPokemonDevUseCase.getPokemonImage(name)
    }

    fun getPokemonEvolutionLine(name: String) {
        viewModelScope.launch {
            _pokemonEvolutionLine.value = getAllPokemonDevUseCase.getPokemonEvolutionLine(name)
        }
    }
}