package com.example.modul5

import kotlinx.serialization.Serializable

@Serializable
data class TvShowResponse(
    val results: List<TvShow>
)