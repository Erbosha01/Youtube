package com.geektech7.youtube.di

import com.geektech7.youtube.ui.playlist.PlaylistViewModel
import com.geektech7.youtube.ui.splashscreen.SplashScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { PlaylistViewModel(get()) }
    viewModel { SplashScreenViewModel(get()) }
}