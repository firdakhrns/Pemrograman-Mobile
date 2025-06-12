package com.example.modul5

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.modul5.databinding.FragmentDetailBinding
import kotlinx.coroutines.launch

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val favoriteViewModel: FavoriteViewModel by viewModels()

    private var currentTvShow: TvShow? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        val tvShow = arguments?.getParcelable<TvShow>("tvshow")
        tvShow?.let {
            currentTvShow = it
            binding.tvShow = it
            binding.executePendingBindings()

            binding.openLinkButton.setOnClickListener {
                currentTvShow?.let { tv ->
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.themoviedb.org/tv/${tv.id}"))
                    startActivity(intent)
                }
            }

            binding.backButton.setOnClickListener {
                requireActivity().supportFragmentManager.popBackStack()
            }

            lifecycleScope.launch {
                val isFav = favoriteViewModel.isFavorite(it)
                updateFavIcon(isFav)

                binding.favIconButton.setOnClickListener {
                    favoriteViewModel.toggleFavorite(tvShow)
                    lifecycleScope.launch {
                        updateFavIcon(favoriteViewModel.isFavorite(tvShow))
                    }
                }
            }
        }

        return binding.root
    }

    private fun updateFavIcon(isFav: Boolean) {
        binding.favIconButton.setImageResource(
            if (isFav) R.drawable.ic_favorite else R.drawable.ic_favorite_border
        )
        val descRes = if (isFav) R.string.remove_from_favorite else R.string.add_to_favorite
        binding.favIconButton.contentDescription = getString(descRes)
    }
}