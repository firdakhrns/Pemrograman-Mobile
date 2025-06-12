package com.example.modul5

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DramaViewModel(private val repository: TmdbRepository) : ViewModel() {

    private val _tvShows = MutableStateFlow<List<TvShow>>(emptyList())
    val tvShows: StateFlow<List<TvShow>> = _tvShows

    init {
        loadTvShows()
    }

    private fun loadTvShows() {
        viewModelScope.launch {
            try {
                val response = repository.getChineseTvShows()
                _tvShows.value = response.results
                Log.d("DramaViewModel", "Loaded ${response.results.size} Chinese dramas.")
            } catch (e: Exception) {
                Log.e("DramaViewModel", "Failed to load data", e)
            }
        }
    }
}