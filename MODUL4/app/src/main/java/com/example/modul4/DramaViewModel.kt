package com.example.modul4

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DramaViewModel : ViewModel() {

    private val _dramas = MutableStateFlow<List<Drama>>(emptyList())
    val dramas: StateFlow<List<Drama>> = _dramas

    private val _selectedDrama = MutableStateFlow<Drama?>(null)
    val selectedDrama: StateFlow<Drama?> = _selectedDrama

    init {
        _dramas.value = listOf(
            Drama(
                "Mysterious Lotus Casebook", "2023 · Mystery, Wuxia", "Rating: 8.7", "40 Episodes",
                "https://i.mydramalist.com/kAozjj_4c.jpg?v=1",
                "https://www.iq.com/album/mysterious-lotus-casebook-2023-hg4cefqzed?lang=en_us"
            ),
            Drama(
                "Love Game In Eastern Fantasy", "2024 · Romance, Wuxia, Fantasy", "Rating: 8.5", "32 Episodes",
                "https://i.mydramalist.com/VXOLzy_4c.jpg?v=1",
                "https://wetv.vip/en/play/227hqhmxvabwggz/d4100tnphtz"
            ),
            Drama(
                "Melody of Golden Age", "2024 · Historical, Mystery, Romance, Drama", "Rating: 8.1", "40 Episodes",
                "https://i.mydramalist.com/d0Q62d_4c.jpg?v=1",
                "https://www.iq.com/album/melody-of-golden-age-2025-vobwm47vvd?lang=en_us"
            ),
            Drama(
                "One And Only", "2021 · Military, Historical, Romance, Political", "Rating: 8.6", "24 Episodes",
                "https://i.mydramalist.com/BLrkR_4c.jpg?v=1",
                "https://www.iq.com/album/one-and-only-2021-24mppdujjp9?lang=en_us"
            ),
            Drama(
                "The Prisoner of Beauty", "2025 · Historical, Romance, Political", "Rating: 8.9", "36 Episodes",
                "https://i.mydramalist.com/mOE1XJ_4c.jpg?v=1",
                "https://wetv.vip/en/play/nwo9p9nml6dgm8l/e41010dzbwf-EP01%3A_The_Prisoner_of_Beauty"
            )
        )

        Log.d("DramaViewModel", "Drama list initialized with ${_dramas.value.size} items")
    }

    fun selectDrama(drama: Drama) {
        _selectedDrama.value = drama
        Log.d("DramaViewModel", "Drama selected: ${drama.title}")
    }
}