package com.geektech7.youtube

import android.app.Application
import com.geektech7.youtube.data.network.networkModule
import com.geektech7.youtube.di.repoModule
import com.geektech7.youtube.di.roomModule
import com.geektech7.youtube.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(networkModule, roomModule, repoModule, viewModelModule))
        }
    }

}