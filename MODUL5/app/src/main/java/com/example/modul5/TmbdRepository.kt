package com.example.modul5

class TmdbRepository(private val apiService: TmdbApiService) {
    suspend fun getChineseTvShows(): TvShowResponse {
        return apiService.getChineseTvShows(
            apiKey = "36854acbbff7b761e0f196e36d1fc1a9",
            startDate = "2023-01-01",
            endDate = "2025-05-31"
        )
    }
}