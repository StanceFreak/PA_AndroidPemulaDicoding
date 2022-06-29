package com.example.subimisidicoding.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.subimisidicoding.data.Film
import com.example.subimisidicoding.data.FilmData
import com.example.subimisidicoding.databinding.ActivityDetailBinding
import com.example.subimisidicoding.local.FilmFavEntity
import com.example.subimisidicoding.viewmodel.FilmFavViewModel
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: FilmFavViewModel
    private var dataList: ArrayList<Film> = arrayListOf()
    private var isFav: Boolean = false

    companion object {
        const val FILM_EXTRAS = "film_extras"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        viewModel = ViewModelProviders.of(this).get(FilmFavViewModel::class.java)

        setupUI()
        setupActionBar()

        setContentView(binding.root)
    }

    private fun setupActionBar() {
        val actionBar = supportActionBar
        actionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            elevation = 0f
        }
    }

    private fun setupUI() {

        val data = intent.extras?.getInt(FILM_EXTRAS)

        if (data != null) {

            getMovieDetailById(data)

            viewModel.getFavoriteById(data).observe(this)  { favData ->
                isFav = favData != null
                favData?.let {
                    if (it.isFavorite == true) {
                        binding.tbFav.isChecked = true
                        binding.tvFav.text = "Favorited"
                    }
                    else {
                        binding.tbFav.isChecked = false
                        binding.tvFav.text = "Add to favorites"
                    }
                }
            }
        }
    }

    private fun getMovieDetailById(id: Int) {
        dataList.addAll(FilmData.listData)
        val movieData = dataList[id]
        binding.apply {
            Picasso.get().load(movieData.poster).into(ivDetailPoster)
            tvDetailTitle.text = movieData.title
            tvDetailDirector.text = "Sutradara : ${movieData.sutaradara}"
            tvDetailCast.text = "Pemeran : ${movieData.pemeran}"
            tvDetailRelease.text = "Tanggal Rilis : ${movieData.tanggalRilis}"
            tvDetailGenre.text = "Genre : ${movieData.genre}"
            tvDetailDesc.text = movieData.desc
            tbFav.setOnClickListener {

                if (tbFav.isChecked) {
                    tbFav.isChecked = true
                    tvFav.text = "Favorited"
                    isFav = true
                    val favData = FilmFavEntity(
                            movieData.movieId,
                            isFav,
                            movieData.title,
                            movieData.poster,
                            movieData.desc,
                            movieData.sutaradara,
                            movieData.pemeran,
                            movieData.tanggalRilis,
                            movieData.genre
                    )
                    viewModel.addFav(favData)
                }
                else {
                    binding.tbFav.isChecked = false
                    binding.tvFav.text = "Add to favorites"
                    isFav = false
                    viewModel.deleteFav(movieData.movieId)
                }
            }
        }
    }
}