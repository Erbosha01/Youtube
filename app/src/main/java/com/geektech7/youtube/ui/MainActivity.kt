package com.geektech7.youtube.ui

import android.view.LayoutInflater
import com.geektech7.youtube.base.BaseActivity
import com.geektech7.youtube.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun inflateViewBinding(layoutInflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
    }

    override fun initListener() {
    }

}