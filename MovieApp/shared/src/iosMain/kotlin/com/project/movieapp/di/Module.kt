package com.project.movieapp.di

import com.project.movieapp.base.presentation.executor.MainDispatcher
import com.project.movieapp.data.factory.ApiService
import com.project.movieapp.data.factory.DriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single { DriverFactory() }
    single { ApiService() }
    single { MainDispatcher() }
}