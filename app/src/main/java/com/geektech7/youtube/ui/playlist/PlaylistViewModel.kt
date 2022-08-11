package com.geektech7.youtube.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.geektech7.youtube.base.BaseViewModel
import com.geektech7.youtube.data.domain.Resource
import com.geektech7.youtube.data.repository.Repository
import com.geektech7.youtube.model.Playlist

class PlaylistViewModel: BaseViewModel() {
    private val repo = Repository()

    private val _playlist = MutableLiveData<Playlist>()
    private val _result = MutableLiveData<Boolean>()
    private val _local = MutableLiveData<Boolean>()

    val playlist = _result.switchMap {
        repo.getPlaylist()
    }

    val setPlaylist = _playlist.switchMap {
        repo.setPlaylist(it)
    }

    val localPlaylist = _local.switchMap {
        repo.getLocalPlaylist()
    }

    fun getLocalPlaylist() {
        _local.value = true
    }

    fun getPlaylist() {
        _result.value = true
    }

    fun setPlaylist(playlist: Playlist) {
        _playlist.value = playlist
    }

}