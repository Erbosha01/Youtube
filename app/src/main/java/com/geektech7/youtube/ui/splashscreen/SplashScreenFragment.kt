package com.geektech7.youtube.ui.splashscreen

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geektech7.youtube.R
import com.geektech7.youtube.base.BaseFragment
import com.geektech7.youtube.data.domain.Resource
import com.geektech7.youtube.databinding.FragmentSplashScreenBinding
import com.geektech7.youtube.extensions.load
import org.koin.androidx.viewmodel.ext.android.viewModel

@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : BaseFragment<FragmentSplashScreenBinding, SplashScreenViewModel>() {

    override val viewModel: SplashScreenViewModel by viewModel()

    override fun inflateViewBinding(
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentSplashScreenBinding {
        return FragmentSplashScreenBinding.inflate(layoutInflater, container, false)
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

        viewModel.setPlaylist.observe(viewLifecycleOwner) {
            if(it.status == Resource.Status.SUCCESS && it.data == true) {
                binding.imgLogo.load("https://upload.wikimedia.org/wikipedia/commons/thumb/9/9e/YouTube_Logo_%282013-2017%29.svg/1280px-YouTube_Logo_%282013-2017%29.svg.png")
                Handler(Looper.getMainLooper()!!).postDelayed({
                    findNavController().navigate(R.id.action_splashScreenFragment_to_playlistFragment, null)
                }, 1000)
            }
        }

    }

    override fun initListener() {
    }

}