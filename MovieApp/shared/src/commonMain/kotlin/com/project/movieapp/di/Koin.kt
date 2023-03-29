package com.project.movieapp.di

import com.project.movieapp.data.repository.local.datasource.MovieListLocalDataSource
import com.project.movieapp.data.repository.local.datasourceimpl.MovieListLocalDataSourceImpl
import com.project.movieapp.data.repository.remote.datasource.MovieListRemoteDataSource
import com.project.movieapp.data.repository.remote.datasourceimpl.MovieListRemoteDataSourceImpl
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules (
            dataSourceModule,
            platformModule()
        )
    }


val dataSourceModule = module {
    single<MovieListRemoteDataSource> { MovieListRemoteDataSourceImpl(get())}
    single<MovieListLocalDataSource> { MovieListLocalDataSourceImpl(get()) }
}