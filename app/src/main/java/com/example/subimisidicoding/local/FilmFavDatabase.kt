package com.example.subimisidicoding.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities =[FilmFavEntity::class],
    version = 1,
    exportSchema = false
)

abstract class FilmFavDatabase : RoomDatabase() {

    abstract fun dao(): FilmFavDao

    companion object {
        @Volatile
        private var INSTANCE: FilmFavDatabase? = null

        fun getDatabase(context: Context): FilmFavDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        FilmFavDatabase::class.java,
                        "fav_database"
                )
                        .fallbackToDestructiveMigration()
                        .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}