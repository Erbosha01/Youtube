package com.geektech7.youtube.ui.splashscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.geektech7.youtube.base.BaseViewModel
import com.geektech7.youtube.data.repository.Repository
import com.geektech7.youtube.model.Playlist

class SplashScreenViewModel(private val repo: Repository): BaseViewModel() {


    private val _playlist = MutableLiveData<Playlist>()
    private val _result = MutableLiveData<Boolean>()

    val playlist = _result.switchMap {
        repo.getPlaylist()
    }

    val setPlaylist = _playlist.switchMap {
        repo.setPlaylist(it)
    }

    fun getPlaylist() {
        _result.value = true
    }

    fun setPlaylist(playlist: Playlist) {
        _playlist.value = playlist
    }
}