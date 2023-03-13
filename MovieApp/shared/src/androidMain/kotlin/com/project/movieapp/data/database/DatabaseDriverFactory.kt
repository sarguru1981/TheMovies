package com.project.movieapp.data.database

import android.content.Context
import com.project.movie.database.MovieDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {

    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(MovieDatabase.Schema, context, "MovieDatabase.db")
    }
}