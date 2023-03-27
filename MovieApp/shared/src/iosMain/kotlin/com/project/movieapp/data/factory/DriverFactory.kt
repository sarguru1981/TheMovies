package com.project.movieapp.data.factory

import com.project.movie.database.MovieDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(MovieDatabase.Schema,"MovieDatabase.db")
    }
}

actual class ApiService {
    actual fun build(): HttpClient {
        return HttpClient(Darwin) {
            engine {
                configureRequest {
                    setAllowsCellularAccess(true)
                }
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
        }
    }
}
