package com.example.subimisidicoding.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.subimisidicoding.R
import com.example.subimisidicoding.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val FILM_EXTRAS = "film_extras"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)

        setupUI()

        setContentView(binding.root)
    }

    private fun setupUI() {
        TODO("Not yet implemented")
    }
}