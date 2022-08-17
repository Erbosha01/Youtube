package com.geektech7.youtube.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB: ViewBinding, VM: ViewModel?>: Fragment() {

    protected lateinit var binding: VB
    protected abstract val viewModel: VM
    protected abstract fun inflateViewBinding(layoutInflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateViewBinding(layoutInflater, container, savedInstanceState)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initListener()
    }

    abstract fun initView()
    abstract fun initListener()
}