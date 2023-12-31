package com.example.pokedex_android.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex_android.domain.model.Pokemon
import com.example.pokedex_android.domain.usecase.GetAllFavoritePokemonUseCase
import com.example.pokedex_android.domain.usecase.GetAllPokemonUseCase
import com.example.pokedex_android.domain.usecase.SearchPokemonUseCase
import com.example.pokedex_android.ui.state.ResponseViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllPokemonUseCase: GetAllPokemonUseCase,
    private val searchPokemonUseCase: SearchPokemonUseCase,
    private val getAllFavoritePokemonUseCase: GetAllFavoritePokemonUseCase
)  : ViewModel() {

    private var _pokemonResponse = MutableLiveData<ResponseViewState<List<Pokemon>>>()
    val pokemonResponse: LiveData<ResponseViewState<List<Pokemon>>> = _pokemonResponse

    fun getAllPokemon() = viewModelScope.launch(Dispatchers.IO) {
        _pokemonResponse.postValue(ResponseViewState.Loading())
        getAllPokemonUseCase().onSuccess {
            _pokemonResponse.postValue(ResponseViewState.Success(it))
        }.onFailure {
            _pokemonResponse.postValue(ResponseViewState.Error(it))
        }
    }

    fun searchPokemon(pokemon: String): LiveData<List<Pokemon>> {
        return searchPokemonUseCase.searchPokemonFromDatabase(pokemon)
    }

    fun getAllFavoritePokemon(): LiveData<List<Pokemon>> {
        return getAllFavoritePokemonUseCase.getAllFavoritePokemon()
    }
}