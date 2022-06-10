package com.example.subimisidicoding.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FilmFavDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFav (filmFavEntity: FilmFavEntity)

    @Query("DELETE FROM fav_table WHERE fav_table.id = :id")
    suspend fun deleteFav (id: String): Int

    @Query("SELECT * FROM fav_table")
    fun getFavorite() : LiveData<List<FilmFavEntity>>
}
