package com.project.movieapp.data.repository.cache

import com.project.movieapp.data.factory.Context
import com.project.movieapp.data.factory.getData
import com.project.movieapp.data.factory.getListData
import com.project.movieapp.data.factory.putData
import kotlinx.coroutines.flow.Flow

class PreferenceDataStore (val context: Context) {

    suspend fun <T> put(key: String, `object`: T) {
        context.putData(key, `object`)
    }

    inline fun <reified T> getData(key: String): Flow<T> =
        context.getData(key)

    inline fun <reified T> getListData(key: String): Flow<List<T>> =
        context.getListData(key)

}
