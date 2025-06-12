package com.example.modul5

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class TvShow(
    val id: Int,
    val name: String,
    @SerialName("poster_path") val posterPath: String?,
    @SerialName("vote_average") val rating: Double,
    @SerialName("first_air_date") val firstAirDate: String,
    val overview: String
) : Parcelable