package com.project.movieapp.data.base

/**
 * Generic class for holding success response, error response and loading status
 */
sealed class Response<out R> {
    data class Success<out T>(val data: T) : Response<T>()
    data class Error(val errorMessage: String, val throwable: Throwable) : Response<Nothing>()
}

suspend fun <T> getResponse(invoke: suspend () -> T): Response<T> {
    return runCatching {
        Response.Success(invoke())
    }.getOrElse {
        Response.Error("Error", it)
    }
}