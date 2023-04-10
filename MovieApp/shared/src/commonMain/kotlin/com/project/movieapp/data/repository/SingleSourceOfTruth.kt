package com.project.movieapp.data.repository

import com.project.movieapp.data.base.Response
import com.project.movieapp.data.base.getResponse
import com.project.movieapp.domain.entity.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal fun  singleSourceOfTruth (
    getLocalData: suspend () -> List<Movie>,
    getRemoteData: suspend () -> List<Movie>,
    saveDataToLocal: suspend (List<Movie>) -> Unit,
): Flow<Response<List<Movie>>> = flow {
    val localData = getResponse { getLocalData() }
    if (localData is Response.Success && localData.data.isNotEmpty()) {
        emit(localData)
    } else {
        val remoteData = getResponse { getRemoteData() }
        if (remoteData is Response.Success) {
            if (remoteData.data.isNotEmpty()) {
                saveDataToLocal(remoteData.data)
                val localDataUpdated = getResponse { getLocalData() }
                emit(localDataUpdated)
            }
        } else {
            emit(Response.Error("Error", (remoteData as Response.Error).throwable))
        }
    }
}