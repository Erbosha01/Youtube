package com.geektech7.youtube.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.geektech7.youtube.App
import com.geektech7.youtube.data.domain.Resource
import com.geektech7.youtube.data.network.RetrofitClient
import com.geektech7.youtube.model.Playlist
import kotlinx.coroutines.Dispatchers
import org.json.JSONObject




class Repository {

    private val apiService = RetrofitClient

    fun getPlaylist(): LiveData<Resource<Playlist?>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val result = apiService.create().getPlaylist()
        if (result.isSuccessful) {
            emit(Resource.success(result.body()))
        } else {
            val jObjError = result.errorBody()?.string()?.let { JSONObject(it) }
            emit(Resource.error(jObjError?.getJSONObject("error")?.getString("message").toString()))
        }
    }

    fun getLocalPlaylist(): LiveData<Resource<Playlist?>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val result = App.db.dao().getPlaylist()
        emit(Resource.success(result))
    }

    fun setPlaylist(playlist: Playlist): LiveData<Resource<Boolean>> = liveData(Dispatchers.IO) {
        App.db.dao().insert(playlist)
        emit(Resource.success(true))
    }

}