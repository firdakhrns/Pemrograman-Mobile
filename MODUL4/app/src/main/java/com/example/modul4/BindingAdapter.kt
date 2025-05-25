package com.example.modul4

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import android.util.Log

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    Log.d("BindingAdapter", "Loading image: $url")
    if (!url.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(url)
            .into(view)
    }
}