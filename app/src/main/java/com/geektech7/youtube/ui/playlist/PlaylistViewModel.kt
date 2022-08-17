package com.geektech7.youtube.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.geektech7.youtube.base.BaseViewModel
import com.geektech7.youtube.data.domain.Resource
import com.geektech7.youtube.data.repository.Repository
import com.geektech7.youtube.model.Playlist

class PlaylistViewModel(private val repo: Repository): BaseViewModel() {

    private val _local = MutableLiveData<Boolean>()

    val localPlaylist = _local.switchMap {
        repo.getLocalPlaylist()
    }

    fun getLocalPlaylist() {
        _local.value = true
    }

}