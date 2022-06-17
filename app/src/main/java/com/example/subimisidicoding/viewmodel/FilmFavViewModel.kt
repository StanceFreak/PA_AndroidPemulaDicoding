package com.example.subimisidicoding.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.subimisidicoding.data.Film
import com.example.subimisidicoding.local.FilmFavDatabase
import com.example.subimisidicoding.local.FilmFavEntity
import com.example.subimisidicoding.repository.FilmFavRepo
import kotlinx.coroutines.launch

class FilmFavViewModel(application: Application) : AndroidViewModel(application) {

    private val repo: FilmFavRepo
    val getFavorite : LiveData<List<FilmFavEntity>>

    init {
        val movieHelper = FilmFavDatabase.getDatabase(application).dao()
        repo = FilmFavRepo(movieHelper)
        getFavorite = repo.getFavorite()
    }

    fun getFavoriteTest() : LiveData<List<FilmFavEntity>> = repo.getFavorite()

    fun addFav(entity: FilmFavEntity) {
        viewModelScope.launch {
            repo.addFav(entity)
        }
    }

    fun deleteFav(id: Int) {
        viewModelScope.launch {
            repo.deleteFav(id)
        }
    }

    fun getFavoriteById(id: Int) : LiveData<FilmFavEntity> = repo.getFavoriteById(id)


    fun getMovieById(movieId: Int) : LiveData<Film> = repo.getMovieById(movieId)


}