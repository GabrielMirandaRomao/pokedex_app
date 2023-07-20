package com.example.pokedex_android.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex_android.R
import com.example.pokedex_android.databinding.FragmentHomeBinding
import com.example.pokedex_android.ui.adapter.PokemonHomeAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    private var adapter : PokemonHomeAdapter = PokemonHomeAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val window: Window = requireActivity().window
        window.statusBarColor = resources.getColor(R.color.red)
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecyclerView()
        binding.llLoadingPokemons.visibility = View.VISIBLE
        viewModel.getAllPokemon()
        addObserve()
    }

    private fun setupRecyclerView() {
        adapter = PokemonHomeAdapter()
        binding.rvPokemonList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPokemonList.adapter = adapter
    }

    private fun addObserve(){
//        val searchQuery = "%$pokemon%"
//        viewModel.searchPokemon(searchQuery).observe(this) { list ->
//            adapter.updatePokemon(list)
//            binding.llLoadingPokemons.visibility = View.GONE
//        }

        viewModel.pokemonResponse.observe(viewLifecycleOwner){
            Log.d("***Fragment", it.data.toString())
            adapter.updatePokemon(it.data!!)
            binding.llLoadingPokemons.visibility = View.GONE
        }

//        viewModel.pokemonResponse.observe(viewLifecycleOwner) {
//            adapter.updatePokemon(it)
//            binding.llLoadingPokemons.visibility = View.GONE
//        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null) {
            //addObserve(query)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText != null) {
            //addObserve(newText)
        }
        return true
    }

}