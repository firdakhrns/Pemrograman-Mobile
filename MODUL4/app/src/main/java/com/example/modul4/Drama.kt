package com.example.modul4

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Drama(
    val title: String,
    val yearGenre: String,
    val rating: String,
    val episodes: String,
    val imageUrl: String,
    val link: String
) : Parcelable