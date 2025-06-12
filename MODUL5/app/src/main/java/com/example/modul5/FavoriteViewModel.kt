package com.example.modul5

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class FavoriteViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getDatabase(application)
    private val repository = FavoriteRepository(db.favoriteDao())

    val favorites: StateFlow<List<FavoriteTvShow>> = repository.getFavorites()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun toggleFavorite(tvShow: TvShow) {
        viewModelScope.launch {
            val fav = FavoriteTvShow(
                id = tvShow.id,
                name = tvShow.name,
                posterPath = tvShow.posterPath,
                firstAirDate = tvShow.firstAirDate,
                rating = tvShow.rating,
                overview = tvShow.overview
            )
            if (repository.isFavorite(tvShow.id)) {
                repository.remove(fav)
            } else {
                repository.add(fav)
            }
        }
    }

    suspend fun isFavorite(tvShow: TvShow): Boolean {
        return repository.isFavorite(tvShow.id)
    }
}