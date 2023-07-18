package com.example.pokedex_android.ui.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex_android.data.local.PokemonDatabase
import com.example.pokedex_android.data.local.entity.AbilitiesEntity
import com.example.pokedex_android.data.local.entity.PokemonEntity
import com.example.pokedex_android.data.local.repository.PokemonLocalRepository
import com.example.pokedex_android.domain.model.OnePokemonResponse
import com.example.pokedex_android.repository.PokemonRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel(application: Application) : ViewModel() {

    private val pokemonRepository: PokemonRepository = PokemonRepository()

    private val pokemonDao = PokemonDatabase.getDatabase(application).pokemonDao

    private val pokemonLocalRepository: PokemonLocalRepository = PokemonLocalRepository(pokemonDao)

    private var _pokemonResponse = MutableLiveData<List<OnePokemonResponse>>()
    val pokemonResponse: LiveData<List<OnePokemonResponse>> = _pokemonResponse

    init {
        addPokemonMock()
        addPokemonAbilities()
    }

    fun getAllPokemon() {
        viewModelScope.launch {
            val response: List<Response<OnePokemonResponse>> = pokemonRepository.getAllPokemons()
            if (response != null) {
                _pokemonResponse.value = response.map {
                    it.body()!!
                }
            }
        }
    }

    fun addPokemonMock() {
        val pokemonOne = PokemonEntity(0, "", 20, 15, "Charmander", "", "", "", "")
        val pokemonTwo = PokemonEntity(0, "", 32, 30, "Charmeleon","", "", "", "")
        val pokemonThree = PokemonEntity(0, "",60, 50, "Charizard","", "", "", "")

        val pokemonList = listOf(pokemonOne, pokemonTwo, pokemonThree)

        viewModelScope.launch {
            pokemonLocalRepository.addPokemon(pokemonList)
        }
    }

    fun addPokemonAbilities() {
        val abilitiesOne = AbilitiesEntity(0, "Ember", "")
        val abilitiesTwo = AbilitiesEntity(0, "Flame", "")

        val abilitiesList = listOf(abilitiesOne, abilitiesTwo)

        viewModelScope.launch {
            pokemonLocalRepository.addPokemonAbilities(abilitiesList)
        }
    }

//    fun insertPokemon(pokemon: Pokemon){
//        pokemonLocalRepository.addPokemon()
//    }
}