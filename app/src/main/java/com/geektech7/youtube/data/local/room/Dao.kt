package com.geektech7.youtube.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.geektech7.youtube.model.Playlist

@Dao
interface Dao {

    @Insert(onConflict = REPLACE)
    fun insert(playlist: Playlist)

    @Insert
    fun insertALl(playlist: List<Playlist>)

    @Query("SELECT * FROM playlist ")
    fun getPlaylist(): Playlist

}