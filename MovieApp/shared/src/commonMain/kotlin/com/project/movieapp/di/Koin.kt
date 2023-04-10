package com.project.movieapp.di

import com.project.movieapp.data.repository.MovieListRepositoryImpl
import com.project.movieapp.data.repository.cache.PreferenceDataStore
import com.project.movieapp.data.repository.local.datasource.MovieListLocalDataSource
import com.project.movieapp.data.repository.local.datasourceimpl.MovieListLocalDataSourceImpl
import com.project.movieapp.data.repository.remote.datasource.MovieListRemoteDataSource
import com.project.movieapp.data.repository.remote.datasourceimpl.MovieListRemoteDataSourceImpl
import com.project.movieapp.domain.repository.MovieListRepository
import com.project.movieapp.domain.usecases.MovieListUseCase
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules (
            dataSourceModule,
            useCasesModule,
            platformModule()
        )
    }


val dataSourceModule = module {
    single<MovieListRemoteDataSource> { MovieListRemoteDataSourceImpl(get()) }
    single<MovieListLocalDataSource> { MovieListLocalDataSourceImpl(get()) }
    single { PreferenceDataStore(get()) }
    single<MovieListRepository> { MovieListRepositoryImpl(get(), get(), get()) }
}

val useCasesModule: Module = module {
    factory { MovieListUseCase(get()) }
}