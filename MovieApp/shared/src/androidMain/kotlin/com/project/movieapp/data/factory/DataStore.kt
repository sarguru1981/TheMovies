package com.project.movieapp.data.factory

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

const val DATASTORE_NAME = "PREF_DATASTORE"

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(DATASTORE_NAME)

actual suspend fun <T> Context.putData(key: String, `object`: T) {
    try {
        val jsonString = GsonBuilder().create().toJson(`object`)
        dataStore.edit { preferences ->
            preferences[stringPreferencesKey(key)] = jsonString
        }
    } catch (exception: Exception) {
        Log.e("DataStore", "Error writing preferences.", exception)
    }
}

actual inline fun <reified T> Context.getData(key: String): Flow<T> {
    return dataStore.data.catch { exception ->
        if (exception is IOException) {
            Log.e("DataStore", "Error reading preferences.", exception)
            emit(emptyPreferences())
        } else {
            throw exception
        }
    }.map { preferences ->
        val jsonString = preferences[stringPreferencesKey(key)]
        val elements = GsonBuilder().create().fromJson(jsonString, T::class.java)
        elements
    }
}

actual inline fun <reified T> Context.getListData(key: String): Flow<List<T>> {
    return dataStore.data.catch { exception ->
        if (exception is IOException) {
            Log.e("DataStore", "Error reading preferences.", exception)
            emit(emptyPreferences())
        } else {
            throw exception
        }
    }.map { preferences ->
        val jsonString = preferences[stringPreferencesKey(key)] ?: ""
        val type = object : TypeToken<List<T>>() {}.type
        val elements = GsonBuilder().create().fromJson<List<T>>(jsonString, type)
        elements
    }
}

