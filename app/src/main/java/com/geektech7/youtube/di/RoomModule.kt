package com.geektech7.youtube.di

import android.content.Context
import androidx.room.Room
import com.geektech7.youtube.data.local.room.AppDataBase
import org.koin.dsl.module

val roomModule = module {
    single { createAppData(get()) }
}

fun createAppData(context: Context): AppDataBase {
    return Room.databaseBuilder(context, AppDataBase::class.java, "database")
        .allowMainThreadQueries()
        .build()
}
