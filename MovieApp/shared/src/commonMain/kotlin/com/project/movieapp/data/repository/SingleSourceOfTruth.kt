package com.project.movieapp.data.repository

import com.project.movieapp.domain.entity.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal fun  singleSourceOfTruth (
    getLocalData: suspend () -> List<Movie>,
    getRemoteData: suspend () -> List<Movie>,
    saveDataToLocal: suspend (List<Movie>) -> Unit,
): Flow<List<Movie>> = flow {
    val localData =  getLocalData()
    if (localData.isNotEmpty()) {
        emit(localData)
    } else {
        val remoteData = getRemoteData()
        if (remoteData.isNotEmpty()) {
            saveDataToLocal(remoteData)
            val localDataUpdated = getLocalData()
            emit(localDataUpdated)
        }
    }
}