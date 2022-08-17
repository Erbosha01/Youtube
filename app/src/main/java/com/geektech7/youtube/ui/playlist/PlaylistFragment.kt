package com.geektech7.youtube.ui.playlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.geektech7.youtube.base.BaseFragment
import com.geektech7.youtube.data.domain.Resource
import com.geektech7.youtube.databinding.FragmentPlaylistBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlaylistFragment : BaseFragment<FragmentPlaylistBinding, PlaylistViewModel>() {

    override val viewModel: PlaylistViewModel by viewModel()

    override fun inflateViewBinding(
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentPlaylistBinding {
        return FragmentPlaylistBinding.inflate(layoutInflater, container, false)
    }

    override fun initView() {

        viewModel.getLocalPlaylist()

        viewModel.localPlaylist.observe(viewLifecycleOwner) {
            if (it.status == Resource.Status.SUCCESS) {
                val adapter = it.data?.let { it1 -> PlaylistAdapter(it1) }
                binding.recycler.adapter = adapter
            }
        }

        viewModel.progress.observe(viewLifecycleOwner) {
            binding.progress.isVisible = it
        }

    }

    override fun initListener() {
    }

}