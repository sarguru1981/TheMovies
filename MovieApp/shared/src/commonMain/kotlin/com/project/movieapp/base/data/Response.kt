package com.project.movieapp.base.data

/**
 * Generic class for holding success response, error response and loading status
 */
sealed class Response<out R> {
    data class Success<out T>(val data: T) : Response<T>()
    data class Error(val exception: Exception) : Response<Nothing>()
}

/*
suspend fun <T> getResponse(invoke: suspend () -> T): Response<T> {
    return runCatching {
        Response.Success(invoke())
    }.getOrElse {
        Response.Error("Error", it)
    }
}*/
