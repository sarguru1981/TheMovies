package com.project.movieapp.android

import android.app.Application
import com.project.movieapp.BuildConfig
import com.project.movieapp.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class MovieApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@MovieApplication)
        }
    }
}