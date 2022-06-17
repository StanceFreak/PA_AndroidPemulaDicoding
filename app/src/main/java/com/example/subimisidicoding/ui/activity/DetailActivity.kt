package com.example.subimisidicoding.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.subimisidicoding.R
import com.example.subimisidicoding.data.Film
import com.example.subimisidicoding.databinding.ActivityDetailBinding
import com.example.subimisidicoding.local.FilmFavEntity
import com.example.subimisidicoding.viewmodel.FilmFavViewModel
import com.squareup.picasso.Picasso


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: FilmFavViewModel
    private var isFav: Boolean = false
    private var testFav: FilmFavEntity? = null
    private var fav = ArrayList<FilmFavEntity>()

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
        Log.d("test2", data.toString())
        viewModel = ViewModelProviders.of(this).get(FilmFavViewModel::class.java)

        if (data != null) {

            viewModel.getMovieById(data).observe(this, Observer { movieData ->
                Log.d("test2", movieData.movieId.toString())
                movieData?.let {
                    movieData.poster.let { it1 -> Picasso.get().load(it1).into(binding.ivDetailPoster) }
                    binding.apply {
                        movieData.title.let { it1 -> Log.d("test2", it1) }
                        tvDetailTitle.text = movieData.title
                        tvDetailDirector.text = "Sutradara : ${movieData.sutaradara}"
                        tvDetailCast.text = "Pemeran : ${movieData.pemeran}"
                        tvDetailRelease.text = "Tanggal Rilis : ${movieData.tanggalRilis}"
                        tvDetailGenre.text = "Genre : ${movieData.genre}"
                        tvDetailDesc.text = movieData.desc
                    }
                }
            })

            viewModel.getFavoriteById(data).observe(this)  { favData ->
                isFav = favData != null
                if (isFav) {
                    binding.tbFav.isChecked = true
                    binding.tvFav.text = "Favorited"
                }
                else {
                    binding.tbFav.isChecked = false
                    binding.tvFav.text = "Add to favorites"
                }
            }

//            binding.tbFav.setOnClickListener {
//
//                if (binding.tbFav.isChecked) {
//                    binding.tbFav.isChecked = true
//                    binding.tvFav.text = "Favorited"
//                    isFav = true
//                    val favData = FilmFavEntity(
//                            testFav!!.movieId,
//                            isFav,
//                            movieData.title,
//                            movieData.poster,
//                            movieData.desc,
//                            movieData.sutaradara,
//                            movieData.pemeran,
//                            movieData.tanggalRilis,
//                            movieData.genre
//                    )
//                    viewModel.addFav(favData)
//                }
//                else {
//                    binding.tbFav.isChecked = false
//                    binding.tvFav.text = "Add to favorites"
//                    isFav = false
//                    viewModel.deleteFav(movieData.movieId)
//                }
//            }
//
//            Picasso.get().load(data.poster).into(binding.ivDetailPoster)
//            binding.apply {
//                tvDetailTitle.text = data.title
//                tvDetailDirector.text = "Sutradara : ${data.sutaradara}"
//                tvDetailCast.text = "Pemeran : ${data.pemeran}"
//                tvDetailRelease.text = "Tanggal Rilis : ${data.tanggalRilis}"
//                tvDetailGenre.text = "Genre : ${data.genre}"
//                tvDetailDesc.text = data.desc
//                tbFav.setOnClickListener {
//
//                    if (binding.tbFav.isChecked) {
//                        binding.tbFav.isChecked = true
//                        binding.tvFav.text = "Favorited"
//                        isFav = true
//                        val favData = FilmFavEntity(
//                                data.movieId,
//                                isFav,
//                                data.title,
//                                data.poster,
//                                data.desc,
//                                data.sutaradara,
//                                data.pemeran,
//                                data.tanggalRilis,
//                                data.genre
//                        )
//                        viewModel.addFav(favData)
//                    }
//                    else {
//                        binding.tbFav.isChecked = false
//                        binding.tvFav.text = "Add to favorites"
//                        isFav = false
//                        viewModel.deleteFav(fav.movieId)
//                    }
//                }
//            }
        }
    }
}