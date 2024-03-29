package com.example.subimisidicoding.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.subimisidicoding.databinding.RecyclerMainBinding
import com.example.subimisidicoding.local.FilmFavEntity
import com.example.subimisidicoding.ui.activity.DetailActivity
import com.squareup.picasso.Picasso

class AdapterFavorite() : RecyclerView.Adapter<AdapterFavorite.FavViewHolder>() {

    private val data = ArrayList<FilmFavEntity>()

    class FavViewHolder(private val binding: RecyclerMainBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind (entity: FilmFavEntity) {
            entity.poster?.let { Picasso.get().load(it).into(binding.ivPoster) }
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

        holder.itemView.setOnClickListener {
            val i = Intent(holder.itemView.context, DetailActivity::class.java)
            i.putExtra(DetailActivity.FILM_EXTRAS, dataList.movieId)
            holder.itemView.context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return this.data.size
    }

    fun setFavorite(favList: List<FilmFavEntity>) {
        this.data.clear()
        this.data.addAll(favList)
        notifyDataSetChanged()
    }

}
