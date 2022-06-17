package com.example.subimisidicoding.local

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "fav_table")
data class FilmFavEntity(
//        @PrimaryKey(autoGenerate = true)
//        @NonNull
//        val id: Int?,
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "movieId")
        val movieId: Int?,
        @ColumnInfo(name = "isFavorite")
        val isFavorite: Boolean?,
        @ColumnInfo(name = "title")
        val title: String?,
        @ColumnInfo(name = "poster")
        val poster: Int?,
        @ColumnInfo(name = "desc")
        val desc: String?,
        @ColumnInfo(name = "sutaradara")
        val sutaradara: String?,
        @ColumnInfo(name = "pemeran")
        val pemeran: String?,
        @ColumnInfo(name = "tanggalRilis")
        val tanggalRilis: String?,
        @ColumnInfo(name = "genre")
        val genre: String?
) : Parcelable
