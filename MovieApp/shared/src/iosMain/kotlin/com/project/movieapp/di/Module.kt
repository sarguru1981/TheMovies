package com.project.movieapp.di

import com.project.movieapp.data.factory.DriverFactory
import com.project.movieapp.presentation.feature.movielist.MovieListViewModel
import io.ktor.client.engine.darwin.Darwin
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single { DriverFactory() }

    single {
        Darwin.create()
    }

    factory { MovieListViewModel(get()) }
}

object ViewModelProvider : KoinComponent {
    fun getMovieViewModel() = get<MovieListViewModel>()
}
