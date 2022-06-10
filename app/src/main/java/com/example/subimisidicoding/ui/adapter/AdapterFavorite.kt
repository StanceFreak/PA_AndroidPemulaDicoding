package com.example.subimisidicoding.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.subimisidicoding.databinding.RecyclerMainBinding
import com.example.subimisidicoding.local.FilmFavEntity
import com.squareup.picasso.Picasso

class AdapterFavorite() : RecyclerView.Adapter<AdapterFavorite.FavViewHolder>() {

    private val data: ArrayList<FilmFavEntity> = arrayListOf()

    class FavViewHolder(private val binding: RecyclerMainBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind (entity: FilmFavEntity) {
            Picasso.get().load(entity.poster).into(binding.ivPoster)
            binding.tvTitle.text = entity.title
            binding.tvDesc.text = entity.desc
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewHolder {
        val itemBinding = RecyclerMainBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FavViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: FavViewHolder, position: Int) {
        val dataList = this.data[position]
        holder.bind(dataList)
    }

    override fun getItemCount(): Int {
        return this.data.size
    }

    fun setFavorite(favList: ArrayList<FilmFavEntity>) {
        this.data.clear()
        this.data.addAll(favList)
        notifyDataSetChanged()
    }

}
