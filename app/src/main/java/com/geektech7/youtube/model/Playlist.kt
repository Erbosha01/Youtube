package com.geektech7.youtube.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Playlist(

    @PrimaryKey(autoGenerate = false)
    var id: Int = 1,

    val etag: String,
    val items: List<Item>,
    val kind: String,
    val nextPageToken: String,
    val pageInfo: PageInfo
)