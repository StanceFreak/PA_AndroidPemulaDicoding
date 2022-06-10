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
        @PrimaryKey(autoGenerate = true)
        @NonNull
        val id: Int,
        @ColumnInfo(name = "title")
        val title: String,
        @ColumnInfo(name = "poster")
        val poster: Int,
        @ColumnInfo(name = "desc")
        val desc: String
) : Parcelable
