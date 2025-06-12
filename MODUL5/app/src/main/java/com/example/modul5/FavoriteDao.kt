package com.example.modul5

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToFavorite(tvShow: FavoriteTvShow)

    @Delete
    suspend fun removeFromFavorite(tvShow: FavoriteTvShow)

    @Query("SELECT * FROM favorite_tv_shows")
    fun getAllFavorites(): Flow<List<FavoriteTvShow>>

    @Query("SELECT * FROM favorite_tv_shows WHERE id = :id LIMIT 1")
    suspend fun getFavoriteById(id: Int): FavoriteTvShow?
}