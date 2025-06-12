package com.example.modul5

import android.util.Log
import kotlinx.coroutines.flow.Flow

class FavoriteRepository(private val dao: FavoriteDao) {

    fun getFavorites(): Flow<List<FavoriteTvShow>> = dao.getAllFavorites()

    suspend fun isFavorite(id: Int): Boolean = dao.getFavoriteById(id) != null

    suspend fun add(tvShow: FavoriteTvShow) {
        dao.addToFavorite(tvShow)
    }

    suspend fun remove(tvShow: FavoriteTvShow) {
        dao.removeFromFavorite(tvShow)
    }
}