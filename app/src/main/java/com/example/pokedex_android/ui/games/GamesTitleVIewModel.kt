package com.example.pokedex_android.ui.games

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GamesTitleVIewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is games Fragment"
    }
    val text: LiveData<String> = _text
}