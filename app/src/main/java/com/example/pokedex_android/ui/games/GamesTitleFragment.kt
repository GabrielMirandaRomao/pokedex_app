package com.example.pokedex_android.ui.games

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pokedex_android.databinding.FragmentGalleryBinding
import com.example.pokedex_android.databinding.FragmentGamesTitlesBinding
import com.example.pokedex_android.ui.gallery.GalleryViewModel

class GamesTitleFragment : Fragment() {

    private var _binding: FragmentGamesTitlesBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val gamesTitleViewModel =
            ViewModelProvider(this).get(GamesTitleVIewModel::class.java)

        _binding = FragmentGamesTitlesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGame
        gamesTitleViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}