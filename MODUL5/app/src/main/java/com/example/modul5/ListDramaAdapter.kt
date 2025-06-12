package com.example.modul5

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.modul5.databinding.ItemDramaBinding

class ListDramaAdapter(
    private var list: List<TvShow>,
    private val onDetailClick: (TvShow) -> Unit
) : RecyclerView.Adapter<ListDramaAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: ItemDramaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemDramaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val tvShow = list[position]
        val context = holder.binding.root.context

        holder.binding.tvShow = tvShow

        holder.binding.buttonDetail.setOnClickListener {
            onDetailClick(tvShow)
        }

        holder.binding.buttonLink.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.themoviedb.org/tv/${tvShow.id}"))
            context.startActivity(intent)
        }
    }

    fun updateData(newList: List<TvShow>) {
        list = newList
        notifyDataSetChanged()
    }
}