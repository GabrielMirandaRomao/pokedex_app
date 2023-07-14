package com.example.pokedex_android.ui.pokemonDetail

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.pokedex_android.MainActivity
import com.example.pokedex_android.R
import com.example.pokedex_android.databinding.FragmentPokemonDetailsBinding
import com.example.pokedex_android.util.setTypeBackground
import com.example.pokedex_android.util.setTypeBackgroundDarker

class PokemonFragmentDetail() : Fragment() {

    private val args: PokemonFragmentDetailArgs by navArgs()
    private lateinit var binding: FragmentPokemonDetailsBinding
    private lateinit var pokemonDetailViewModel: PokemonDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val window: Window = requireActivity().window
        window.statusBarColor =
            resources.getColor(setTypeBackground(args.pokemonInfo.types[0].type.name))
        binding = FragmentPokemonDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pokemonDetailViewModel = ViewModelProvider(this)[PokemonDetailViewModel::class.java]
        addObserve()
        setViewsContents()
    }

    override fun onResume() {
        (activity as MainActivity).supportActionBar?.setBackgroundDrawable(
            resources.getDrawable(
                setTypeBackground(args.pokemonInfo.types[0].type.name)
            )
        )
        pokemonDetailViewModel.getPokemonDev(args.pokemonInfo.name)
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as MainActivity).supportActionBar?.setBackgroundDrawable(resources.getDrawable(R.color.red))
    }

    private fun setViewsContents() {
        binding.vHeader.backgroundTintList = ContextCompat.getColorStateList(requireContext(), setTypeBackground(args.pokemonInfo.types[0].type.name))
        binding.tvPokemonName.text = args.pokemonInfo.name
        binding.tvPokemonNumber.text = "#${args.pokemonInfo.id.toString().padStart(3, '0')}"

        if (args.pokemonInfo.types.size > 1) {
            binding.tvPokemonSecondType.visibility = View.VISIBLE

            binding.tvPokemonType.text = args.pokemonInfo.types[0].type.name
            binding.tvPokemonSecondType.text = args.pokemonInfo.types[1].type.name

            binding.tvPokemonType.backgroundTintList = ContextCompat.getColorStateList(requireContext(), setTypeBackgroundDarker(args.pokemonInfo.types[0].type.name))
            binding.tvPokemonSecondType.backgroundTintList = ContextCompat.getColorStateList(requireContext(), setTypeBackgroundDarker(args.pokemonInfo.types[1].type.name))
        } else {
            binding.tvPokemonType.text = args.pokemonInfo.types[0].type.name
            binding.tvPokemonType.backgroundTintList = ContextCompat.getColorStateList(requireContext(), setTypeBackgroundDarker(args.pokemonInfo.types[0].type.name))

            binding.tvPokemonSecondType.visibility = View.GONE
        }

        binding.tvSpeciesValue.text = args.pokemonInfo.speciesResponse.name
        binding.tvHeightValue.text = args.pokemonInfo.height.toString()
        binding.tvWeightValue.text = args.pokemonInfo.weight.toString()

        Glide.with(this)
            .load(args.pokemonInfo.spritesResponse?.other?.officialArt?.frontDefault)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.ivPokemon)
    }

    private fun addObserve() {
        pokemonDetailViewModel.pokemon.observe(viewLifecycleOwner) { pokeItem ->
            pokeItem.body()?.map {
                binding.tvMale.text = it.gender[0].toString()
                binding.tvFemale.text = it.gender[1].toString()
            }
        }
    }

}