package com.example.pokedex_android.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.util.query
import com.example.pokedex_android.R
import com.example.pokedex_android.databinding.FragmentHomeBinding
import com.example.pokedex_android.ui.adapter.PokemonHomeAdapter
import com.example.pokedex_android.ui.state.ResponseViewState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


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
        binding.llLoadingPokemons.visibility = View.VISIBLE
        viewModel.getAllPokemon()
        setupRecyclerView()
        requestData()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllPokemon()
    }

    private fun setupRecyclerView() {
        adapter = PokemonHomeAdapter()
        binding.rvPokemonList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPokemonList.adapter = adapter
    }

    private fun requestData() {
        lifecycleScope.launch{
            viewModel.pokemonResponse.observe(viewLifecycleOwner) { response ->
                when (response) {
                    is ResponseViewState.Success -> {
                        response.data?.let {
                            Log.d("***Home", it.toString())
                            adapter.updatePokemon(it)
                        }
                        binding.llLoadingPokemons.visibility = View.GONE
                    }
                    is ResponseViewState.Error -> {
                        response.let {
                            binding.rvPokemonList.visibility = View.GONE
                            Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                    is ResponseViewState.Loading -> {
                        binding.rvPokemonList.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    private fun searchThroughDatabase(pokemon: String) {
        val searchQuery = "%$pokemon%"
        viewModel.searchPokemon(searchQuery).observe(this) { list ->
            adapter.updatePokemon(list)
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null) {
            searchThroughDatabase(query)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText != null) {
            searchThroughDatabase(newText)
        }
        return true
    }

}