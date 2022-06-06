package com.example.subimisidicoding.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(
        val title: String,
        val poster: Int,
        val desc: String
) : Parcelable
