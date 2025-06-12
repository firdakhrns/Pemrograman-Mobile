package com.example.modul5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modul5.databinding.FragmentHomeBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: DramaViewModel by viewModels {
        DramaViewModelFactory(TmdbRepository(NetworkModule.apiService))
    }
    private lateinit var adapter: ListDramaAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = ListDramaAdapter(emptyList()) { selectedTvShow ->
            val fragment = DetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("tvshow", selectedTvShow)
                }
            }
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.tvShows.collectLatest { tvList ->
                adapter.updateData(tvList)
            }
        }

        binding.buttonFavorite.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FavoriteFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}