package com.geektech7.youtube.ui.splashscreen

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.geektech7.youtube.R
import com.geektech7.youtube.base.BaseFragment
import com.geektech7.youtube.databinding.FragmentSplashScreenBinding
import com.geektech7.youtube.extensions.load

@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : BaseFragment<FragmentSplashScreenBinding, SplashScreenViewModel>() {

    override val viewModel: SplashScreenViewModel by lazy {
        ViewModelProvider(this)[SplashScreenViewModel::class.java]
    }

    override fun inflateViewBinding(
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentSplashScreenBinding {
        return FragmentSplashScreenBinding.inflate(layoutInflater, container, false)
    }

    override fun initView() {
        binding.imgLogo.load("https://upload.wikimedia.org/wikipedia/commons/thumb/9/9e/YouTube_Logo_%282013-2017%29.svg/1280px-YouTube_Logo_%282013-2017%29.svg.png")
        Handler(Looper.getMainLooper()!!).postDelayed({
            findNavController().navigate(R.id.action_splashScreenFragment_to_playlistFragment, null)
        }, 5000)
    }

    override fun initListener() {
    }

}