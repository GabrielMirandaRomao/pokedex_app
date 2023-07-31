package com.example.pokedex_android.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.pokedex_android.databinding.EvolutionItemBinding
import com.example.pokedex_android.domain.model.Pokemon
import com.example.pokedex_android.util.setTypeColor

class PokemonEvolutionAdapter(): RecyclerView.Adapter<PokemonEvolutionAdapter.PokemonViewHolder>() {

    class PokemonViewHolder(val binding: EvolutionItemBinding) : RecyclerView.ViewHolder(binding.root)

    private var pokemonData = emptyList<Pokemon>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val item = EvolutionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(item)
    }

    override fun getItemCount() = pokemonData.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.binding.apply {
            tvPokemonName.text = pokemonData[position].name

            cvEvolution.setTypeColor(pokemonData[position].types[0].name)

            Glide.with(holder.itemView)
                .load(pokemonData[position].imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(ivFormDefault)
        }
    }

    fun updateEvolutionLine(pokemon: List<Pokemon>) {
        this.pokemonData = pokemon
        notifyDataSetChanged()
    }
}