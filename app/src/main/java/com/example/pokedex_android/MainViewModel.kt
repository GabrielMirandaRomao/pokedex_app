package com.example.pokedex_android

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex_android.domain.model.OnePokemonResponse
import com.example.pokedex_android.repository.PokemonRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val pokemonRepository: PokemonRepository = PokemonRepository()

    private var _pokemonResponse = MutableLiveData<List<OnePokemonResponse>>()
    val pokemonResponse : LiveData<List<OnePokemonResponse>> = _pokemonResponse

    fun getAllPokemon(){
        viewModelScope.launch {
            val response: List<Response<OnePokemonResponse>> = pokemonRepository.getAllPokemons()
            if(response != null){
                _pokemonResponse.value = response.map {
                    it.body()!!
                }
            }
        }
    }

}