package com.example.pokedex_android.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex_android.data.remote.models.pokemonModel.CompletePokemonResponse
import com.example.pokedex_android.repository.PokemonRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel() : ViewModel() {

    private val pokemonRepository: PokemonRepository = PokemonRepository()

    private var _pokemonResponse = MutableLiveData<List<CompletePokemonResponse>>()
    val pokemonResponse: LiveData<List<CompletePokemonResponse>> = _pokemonResponse

    fun getAllPokemon() {
        viewModelScope.launch {
            val response: List<Response<CompletePokemonResponse>> = pokemonRepository.getAllPokemons()
            if (response != null) {
                _pokemonResponse.value = response.map {
                    it.body()!!
                }
            }
        }
    }
}