package com.geektech7.youtube

import android.app.Application
import androidx.room.Room
import com.geektech7.youtube.data.local.room.AppDataBase


class App: Application() {

    companion object {
        lateinit var db: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(applicationContext, AppDataBase::class.java, "database")
            .allowMainThreadQueries()
            .build()
    }
}