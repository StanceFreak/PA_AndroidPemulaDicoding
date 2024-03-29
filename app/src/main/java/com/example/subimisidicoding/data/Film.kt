package com.example.subimisidicoding.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(
        val movieId: Int,
        val title: String,
        val poster: Int,
        val desc: String,
        val sutaradara: String,
        val pemeran: String,
        val tanggalRilis: String,
        val genre: String
) : Parcelable
