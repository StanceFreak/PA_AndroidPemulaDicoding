package com.example.subimisidicoding.repository

import androidx.lifecycle.LiveData
import com.example.subimisidicoding.data.Film
import com.example.subimisidicoding.local.FilmFavDao
import com.example.subimisidicoding.local.FilmFavEntity

class FilmFavRepo(private val dao: FilmFavDao) {
    fun getFavorite() : LiveData<List<FilmFavEntity>> = dao.getFavorite()

    suspend fun addFav(bookFavEntity: FilmFavEntity) {
        dao.addFav(bookFavEntity)
    }

    suspend fun deleteFav(id: Int) {
        dao.deleteFav(id)
    }

    fun getFavoriteById(id: Int) : LiveData<FilmFavEntity> {
         return dao.getFavoriteById(id)
    }

    fun getMovieById(movieId: Int) : LiveData<Film> = dao.getMovieById(movieId)

}