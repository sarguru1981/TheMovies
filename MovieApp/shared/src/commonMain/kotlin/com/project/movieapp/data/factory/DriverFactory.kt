package com.project.movieapp.data.factory

import com.squareup.sqldelight.db.SqlDriver
import io.ktor.client.HttpClient


expect class DriverFactory {
    fun createDriver(): SqlDriver
}