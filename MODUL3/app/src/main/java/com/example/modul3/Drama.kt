package com.example.modul3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Drama(
    val title: String,
    val year: String,
    val genre: String,
    val episodes: String,
    val imageUrl: String,
    val link: String
) : Parcelable