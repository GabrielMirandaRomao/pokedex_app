package com.example.pokedex_android.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.pokedex_android.databinding.PokemonItemBinding
import com.example.pokedex_android.domain.model.Pokemon
import com.example.pokedex_android.ui.home.HomeFragmentDirections
import com.example.pokedex_android.util.setTypeColor

class PokemonHomeAdapter() : RecyclerView.Adapter<PokemonHomeAdapter.PokemonViewHolder>() {

    private var pokemonData = emptyList<Pokemon>()
    private var isAllShiny = false

    class PokemonViewHolder(val binding: PokemonItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val item = PokemonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(item)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.binding.apply {
            if (pokemonData.isEmpty()) {
                mtvNumber.visibility = View.GONE
                mtvName.visibility = View.GONE
            } else {
                mtvNumber.text = "#${pokemonData[position].number.toString().padStart(3, '0')}"
                mtvName.text = pokemonData[position].name

                if (pokemonData[position].types.size > 1) {
                    tvPokemonType.text = pokemonData[position].types[0].name
                    tvPokemonSecondType.visibility = View.VISIBLE
                    tvPokemonSecondType.text = pokemonData[position].types[1].name
                } else {
                    tvPokemonType.text = pokemonData[position].types[0].name
                    tvPokemonSecondType.visibility = View.INVISIBLE
                }

                clCardView.setTypeColor(pokemonData[position].types[0].name)

                val isShiny = isAllShiny
                ivShinyPokemon.visibility = if(isShiny) View.VISIBLE else View.GONE
                ivPokemon.visibility = if(isShiny) View.GONE else View.VISIBLE

                Glide.with(holder.itemView)
                    .load(if(isShiny) pokemonData[position].secondImageUrl else pokemonData[position].imageUrl)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(if(isShiny) ivShinyPokemon else ivPokemon)
            }
        }

        holder.itemView.setOnClickListener {
            val action =
                HomeFragmentDirections.actionPokemonFragmentToPokemonDetailFragment(pokemonData[position])
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount() = pokemonData.size

    fun updatePokemon(pokemon: List<Pokemon>) {
        this.pokemonData = pokemon
        notifyDataSetChanged()
    }

    fun setAllPokemonAsShiny(shiny: Boolean) {
        isAllShiny = shiny
        notifyDataSetChanged()
    }

}