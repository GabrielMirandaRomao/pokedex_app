package com.example.pokedex_android.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex_android.MainViewModel
import com.example.pokedex_android.R
import com.example.pokedex_android.databinding.FragmentHomeBinding
import com.example.pokedex_android.ui.adapter.PokemonHomeAdapter
import com.example.pokedex_android.ui.state.ResponseViewState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: MainViewModel
//    private val homeViewModel: HomeViewModel by viewModels()
    private var adapter : PokemonHomeAdapter = PokemonHomeAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val window: Window = requireActivity().window
        window.statusBarColor = resources.getColor(R.color.red)
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        addObserve()
        setupRecyclerView()
        binding.llLoadingPokemons.visibility = View.VISIBLE
    }

    override fun onResume() {
        viewModel.getAllPokemon()
        super.onResume()
    }

    private fun setupRecyclerView() {
        adapter = PokemonHomeAdapter()
        binding.rvPokemonList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPokemonList.adapter = adapter
    }

    private fun addObserve(){
        viewModel.pokemonResponse.observe(viewLifecycleOwner) {
            adapter.updatePokemon(it)
            binding.llLoadingPokemons.visibility = View.GONE
        }
    }
}