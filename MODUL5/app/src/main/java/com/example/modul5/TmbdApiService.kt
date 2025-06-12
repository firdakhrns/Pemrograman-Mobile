package com.example.modul5

import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbApiService {
    @GET("discover/tv")
    suspend fun getChineseTvShows(
        @Query("api_key") apiKey: String,
        @Query("with_original_language") language: String = "zh",
        @Query("sort_by") sortBy: String = "popularity.desc",
        @Query("first_air_date.gte") startDate: String = "2020-01-01",
        @Query("first_air_date.lte") endDate: String = "2025-05-31"
    ): TvShowResponse
}