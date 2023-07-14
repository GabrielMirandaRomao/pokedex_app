package com.example.pokedex_android.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedex_android.databinding.PokemonItemBinding
import com.example.pokedex_android.domain.model.OnePokemonResponse
import com.example.pokedex_android.domain.model.PokemonModel

//class PokemonViewHolder(private val bind: PokemonItemBinding) : RecyclerView.ViewHolder(bind.root){
//
//    fun bind(pokemon : PokemonModel, pokemonNumber : Int, pokemonData : OnePokemonResponse){
//        bind.materialTvNumber.text = "#${pokemonNumber + 1}"
////        bind.materialTvNumber.text = "#${pokemonData.id}"
//        bind.materialTvName.text = pokemon.name
////        bind.ivPokemon.setImageResource()
//        val url = pokemonData.spritesResponse.let {
////            Picasso.get().load(it).into(bind.ivPokemon)
//        }
//    }
//}