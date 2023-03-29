package com.project.movieapp.data.repository.remote.datasourceimpl

import com.project.movieapp.data.factory.ApiService
import com.project.movieapp.data.model.MovieResponseDTO
import com.project.movieapp.data.repository.remote.datasource.MovieListRemoteDataSource
import com.project.movieapp.data.util.APIConstants
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.ContentType
import io.ktor.http.contentType


class MovieListRemoteDataSourceImpl(
    private val httpClient: HttpClient) : MovieListRemoteDataSource {

    override suspend fun getPopularMovieListFromRemote(url: String, page: Int): MovieResponseDTO {
        return httpClient.get(urlString = "${APIConstants.BASE_URL}$url") {
            contentType(ContentType.Application.Json)
            parameter("api_key", APIConstants.API_KEY)
            parameter("page", page)
        }.body()
    }

}
