package com.example.pokedex_android.ui.pokemonDetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex_android.data.remote.models.pokemonDevModel.PokedevResponse
import com.example.pokedex_android.data.repository.PokemonRepository
import com.example.pokedex_android.domain.usecase.GetAllFavoritePokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getAllFavoritePokemonUseCase: GetAllFavoritePokemonUseCase
) : ViewModel() {

    fun updateFavoritePokemon(isFavorite: Int, number: Int) {
        getAllFavoritePokemonUseCase.updateFavoritePokemon(isFavorite, number)
    }

//    private val pokemonRepository: PokemonRepository = PokemonRepository()

    private var _pokemon = MutableLiveData<Response<PokedevResponse>>()
    val pokemon: LiveData<Response<PokedevResponse>> = _pokemon

    fun getPokemonDev(name: String) {
        viewModelScope.launch {
//            val response : Response<PokedevResponse> = pokemonRepository.getPokemonDev(name)
//            Log.d("***Teste response", "${response.body()}")
//            _pokemon.value = response
        }
   }
}