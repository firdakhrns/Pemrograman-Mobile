package com.example.modul4

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modul4.databinding.FragmentHomeBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: DramaViewModel by viewModels {
        DramaViewModelFactory()
    }
    private lateinit var dramaAdapter: ListDramaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dramaAdapter = ListDramaAdapter(emptyList()) { drama ->
            Log.d("HomeFragment", "Detail clicked: ${drama.title}")
            val fragment = DetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("drama", drama)
                }
            }
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = dramaAdapter
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.dramas.collectLatest { list ->
                Log.d("HomeFragment", "List updated: ${list.size} items")
                dramaAdapter = ListDramaAdapter(list) { drama ->
                    Log.d("HomeFragment", "Detail clicked: ${drama.title}")
                    val fragment = DetailFragment().apply {
                        arguments = Bundle().apply {
                            putParcelable("drama", drama)
                        }
                    }
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .addToBackStack(null)
                        .commit()
                }
                binding.recyclerView.adapter = dramaAdapter
            }
        }
    }
}