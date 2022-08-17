package com.geektech7.youtube.ui

import android.view.LayoutInflater
import androidx.navigation.findNavController
import com.geektech7.youtube.R
import com.geektech7.youtube.base.BaseActivity
import com.geektech7.youtube.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun inflateViewBinding(layoutInflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {

        val navController = findNavController(R.id.nav_host_fragment)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.splashScreenFragment) {
                supportActionBar?.hide()
            } else {
                supportActionBar?.show()
            }
        }

    }

    override fun initListener() {
    }

}