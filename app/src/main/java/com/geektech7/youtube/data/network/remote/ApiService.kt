package com.geektech7.youtube.data.network.remote

import com.geektech7.youtube.BuildConfig
import com.geektech7.youtube.model.Playlist
import com.geektech7.youtube.utils.Const
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("playlists")
    suspend fun getPlaylist(
        @Query("part") part: String = Const.PART,
        @Query("channelId") channelId: String = Const.CHANNEL_ID,
        @Query("key") key: String = BuildConfig.API_KEY
    ): Response<Playlist>
}