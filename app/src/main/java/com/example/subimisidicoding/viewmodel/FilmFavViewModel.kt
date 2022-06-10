package com.example.subimisidicoding.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.subimisidicoding.local.FilmFavDatabase
import com.example.subimisidicoding.local.FilmFavEntity
import com.example.subimisidicoding.repository.FilmFavRepo
import kotlinx.coroutines.launch

class FilmFavViewModel(application: Application) : AndroidViewModel(application) {

    private val repo: FilmFavRepo
    val getFavorite : LiveData<List<FilmFavEntity>>

    init {
        val bookHelper = FilmFavDatabase.getDatabase(application).dao()
        repo = FilmFavRepo(bookHelper)
        getFavorite = repo.getFavorite()
    }

    fun addFav(entity: FilmFavEntity) {
        viewModelScope.launch {
            repo.addFav(entity)
        }
    }

    fun deleteFav(id: String) {
        viewModelScope.launch {
            repo.deleteFav(id)
        }
    }

}