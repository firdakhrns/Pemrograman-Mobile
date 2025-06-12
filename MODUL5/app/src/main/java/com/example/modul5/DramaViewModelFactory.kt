package com.example.modul5

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DramaViewModelFactory(private val repository: TmdbRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DramaViewModel::class.java)) {
            return DramaViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}