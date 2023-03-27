package com.project.movieapp.data.factory

import android.content.Context
import com.project.movie.database.MovieDatabase
import com.project.movieapp.BuildConfig
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import java.util.concurrent.TimeUnit
import kotlinx.serialization.json.Json


actual class DriverFactory(private val context: Context) {

    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(MovieDatabase.Schema, context, "MovieDatabase.db")
    }
}

actual class ApiService {
    actual fun build(): HttpClient {
        return HttpClient(OkHttp) {
            engine {
                config {
                    retryOnConnectionFailure(true)
                    connectTimeout(5, TimeUnit.SECONDS)
                }
            }
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        prettyPrint = true
                        isLenient = true
                    }
                )
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
        }
    }
}
