package com.project.movieapp.di

import com.project.movieapp.data.factory.DriverFactory
import com.project.movieapp.presentation.feature.movielist.MovieListViewModel
import io.ktor.client.engine.android.Android
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single { DriverFactory(get()) }

    single {
        Android.create()
    }

    viewModel {
        MovieListViewModel(get())
    }
}