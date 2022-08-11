package com.geektech7.youtube.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.geektech7.youtube.data.converters.Converters
import com.geektech7.youtube.model.Playlist

@Database(entities = [Playlist::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun dao() : Dao
}