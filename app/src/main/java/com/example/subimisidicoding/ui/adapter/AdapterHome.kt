package com.example.subimisidicoding.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.subimisidicoding.data.Film
import com.example.subimisidicoding.databinding.RecyclerMainBinding
import com.example.subimisidicoding.ui.activity.DetailActivity
import com.squareup.picasso.Picasso

class AdapterHome(private val data : ArrayList<Film>) : RecyclerView.Adapter<AdapterHome.HomeViewHolder>() {

    class HomeViewHolder(private val binding: RecyclerMainBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(film: Film) {
            Picasso.get().load(film.poster).into(binding.ivPoster)
            binding.tvTitle.text = film.title
            binding.tvDesc.text = film.desc
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val itemBinding =RecyclerMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val data = this.data[position]
        holder.bind(data)

        holder.itemView.setOnClickListener {
            val i = Intent(holder.itemView.context, DetailActivity::class.java)
//            val intentData = Film(
//                data.movieId,
//                data.title,
//                data.poster,
//                data.desc,
//                data.sutaradara,
//                data.pemeran,
//                data.tanggalRilis,
//                data.genre
//            )
            i.putExtra(DetailActivity.FILM_EXTRAS, data.movieId)
            holder.itemView.context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return this.data.size
    }

}