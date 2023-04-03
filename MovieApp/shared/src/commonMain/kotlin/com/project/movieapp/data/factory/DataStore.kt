package com.project.movieapp.data.factory

import kotlinx.coroutines.flow.Flow

expect suspend fun <T> Context.putData(key: String, `object`: T)

expect inline  fun <reified T> Context.getData(key: String): Flow<T>

expect inline fun <reified T> Context.getListData(key: String): Flow<List<T>>
