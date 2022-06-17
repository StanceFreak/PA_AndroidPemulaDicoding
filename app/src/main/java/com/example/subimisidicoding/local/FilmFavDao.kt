package com.example.subimisidicoding.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.subimisidicoding.data.Film

@Dao
interface FilmFavDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFav (filmFavEntity: FilmFavEntity)

    @Query("DELETE FROM fav_table WHERE movieId = :id")
    suspend fun deleteFav (id: Int)

    @Query("SELECT * FROM fav_table")
    fun getFavorite() : LiveData<List<FilmFavEntity>>

    @Query("SELECT * FROM fav_table WHERE movieId = :id")
    fun getFavoriteById(id: Int) : LiveData<FilmFavEntity>

    @Query("SELECT * FROM fav_table WHERE movieId = :movieId")
    fun getMovieById(movieId: Int) : LiveData<Film>

}
