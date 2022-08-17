package com.geektech7.youtube.di

import com.geektech7.youtube.data.repository.Repository
import org.koin.dsl.module

val repoModule = module {
    single { Repository(get(), get()) }
}