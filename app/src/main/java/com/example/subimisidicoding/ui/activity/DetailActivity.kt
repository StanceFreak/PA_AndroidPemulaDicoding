package com.example.subimisidicoding.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.subimisidicoding.R
import com.example.subimisidicoding.data.Film
import com.example.subimisidicoding.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

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
        val data = intent.getParcelableExtra<Film>(FILM_EXTRAS)

        if (data != null) {
            Picasso.get().load(data.poster).into(binding.ivDetailPoster)
            binding.apply {
                tvDetailTitle.text = data.title
                tvDetailDirector.text = "Sutradara : ${data.sutaradara}"
                tvDetailCast.text = "Pemeran : ${data.pemeran}"
                tvDetailRelease.text = "Tanggal Rilis : ${data.tanggalRilis}"
                tvDetailGenre.text = "Genre : ${data.genre}"
                tvDetailDesc.text = data.desc
            }
        }
    }
}