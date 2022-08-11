package com.geektech7.youtube.ui.playlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.geektech7.youtube.base.BaseFragment
import com.geektech7.youtube.data.domain.Resource
import com.geektech7.youtube.databinding.FragmentPlaylistBinding

class PlaylistFragment : BaseFragment<FragmentPlaylistBinding, PlaylistViewModel>() {

    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

    override fun inflateViewBinding(
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentPlaylistBinding {
        return FragmentPlaylistBinding.inflate(layoutInflater, container, false)
    }

    override fun initView() {

        viewModel.getPlaylist()

        viewModel.playlist.observe(viewLifecycleOwner) {
            viewModel.progress.value = it.status == Resource.Status.LOADING
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    it.data?.let { it1 -> viewModel.setPlaylist(it1) }
                }
                Resource.Status.ERROR -> {
                }
            }
        }

        viewModel.localPlaylist.observe(viewLifecycleOwner) {
            if (it.status == Resource.Status.SUCCESS) {
                val adapter = it.data?.let { it1 -> PlaylistAdapter(it1) }
                binding.recycler.adapter = adapter
            }
        }

        viewModel.progress.observe(viewLifecycleOwner) {
            binding.progress.isVisible = it
        }

        viewModel.setPlaylist.observe(viewLifecycleOwner) {
            if(it.status == Resource.Status.SUCCESS && it.data == true) {
                viewModel.getLocalPlaylist()
            }
        }

    }

    override fun initListener() {
    }

}