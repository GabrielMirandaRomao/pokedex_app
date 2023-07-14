package com.example.pokedex_android.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex_android.domain.modelLocal.Pokemon
import com.example.pokedex_android.ui.state.ResponseViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

//    private var _pokemonResponse = MutableLiveData<ResponseViewState<List<Pokemon>>>()
//    val pokemonResponse: LiveData<ResponseViewState<List<Pokemon>>> = _pokemonResponse
//
//    private val _searchPokemon = MutableLiveData<LiveData<List<Pokemon>>>()
//    val searchPokemon: LiveData<LiveData<List<Pokemon>>> = _searchPokemon
//
//    fun getAllPokemon() = viewModelScope.launch(Dispatchers.IO) {
//        _pokemonResponse.postValue(ResponseViewState.Loading())
//        getAllPokemonUseCase().onSuccess {
//            _pokemonResponse.postValue(ResponseViewState.Success(it))
//        }.onFailure {
//            _pokemonResponse.postValue(ResponseViewState.Error(it))
//        }
//    }
//
//    fun searchPokemon(pokemon: String) : LiveData<List<Pokemon>> {
//        return searchPokemonUseCase.searchPokemonFromDatabase(pokemon)
//    }
}