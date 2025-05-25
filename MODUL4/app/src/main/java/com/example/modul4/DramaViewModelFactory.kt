package com.example.modul4

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DramaViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DramaViewModel::class.java)) {
            return DramaViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}