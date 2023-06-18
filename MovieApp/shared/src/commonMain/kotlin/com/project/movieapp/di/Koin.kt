package com.project.movieapp.di

import com.project.movieapp.data.mappers.MovieDataMapper
import com.project.movieapp.data.repository.MovieListRepositoryImpl
import com.project.movieapp.data.repository.cache.PreferenceDataStore
import com.project.movieapp.data.repository.local.datasource.MovieListLocalDataSource
import com.project.movieapp.data.repository.local.datasourceimpl.MovieListLocalDataSourceImpl
import com.project.movieapp.data.repository.remote.datasource.MovieListRemoteDataSource
import com.project.movieapp.data.repository.remote.datasourceimpl.MovieListRemoteDataSourceImpl
import com.project.movieapp.data.repository.MovieListRepository
import com.project.movieapp.domain.usecases.MovieListUseCase
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules (
            appModule,
            dataSourceModule,
            useCasesModule,
            platformModule()
        )
    }


val dataSourceModule = module {
    single { MovieDataMapper() }
    single<MovieListRemoteDataSource> { MovieListRemoteDataSourceImpl(get()) }
    single<MovieListLocalDataSource> { MovieListLocalDataSourceImpl(get()) }
    single { PreferenceDataStore(get()) }
    single<MovieListRepository> { MovieListRepositoryImpl(get(), get(), get(), get()) }
}

val useCasesModule: Module = module {
    factory { MovieListUseCase(get()) }
}

val appModule = module {
    single { Json { isLenient = true; ignoreUnknownKeys = true } }
    single {
        HttpClient(get()) {
            install(ContentNegotiation) {
                json(get())
            }
            install(Logging) {
                level = LogLevel.ALL
            }
        }
    }
}