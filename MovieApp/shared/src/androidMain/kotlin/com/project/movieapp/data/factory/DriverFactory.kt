package com.project.movieapp.data.factory

import android.content.Context
import com.project.movie.database.MovieDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import io.ktor.client.HttpClient


actual class DriverFactory(private val context: Context) {

    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(MovieDatabase.Schema, context, "MovieDatabase.db")
    }
}
