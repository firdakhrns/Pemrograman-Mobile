package com.example.modul5

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_tv_shows")
data class FavoriteTvShow(
    @PrimaryKey val id: Int,
    val name: String,
    val posterPath: String?,
    val firstAirDate: String,
    val rating: Double,
    val overview: String
)
fun FavoriteTvShow.toTvShow(): TvShow {
    return TvShow(
        id = this.id,
        name = this.name,
        posterPath = this.posterPath,
        rating = this.rating,
        firstAirDate = this.firstAirDate,
        overview = this.overview
    )
}