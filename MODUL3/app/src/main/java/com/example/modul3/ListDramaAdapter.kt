package com.example.modul3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.modul3.databinding.ItemDramaBinding

class ListDramaAdapter(
    private val listDrama: List<Drama>,
    private val onDetailClick: (Drama) -> Unit
) : RecyclerView.Adapter<ListDramaAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: ItemDramaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemDramaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = listDrama.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val drama = listDrama[position]
        holder.binding.drama = drama

        Glide.with(holder.binding.root.context)
            .load(drama.imageUrl)
            .into(holder.binding.imageView)

        holder.binding.buttonDetail.setOnClickListener {
            onDetailClick(drama)
        }
    }
}