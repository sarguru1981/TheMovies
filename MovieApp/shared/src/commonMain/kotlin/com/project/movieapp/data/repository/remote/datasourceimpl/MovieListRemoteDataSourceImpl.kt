package com.project.movieapp.data.repository.remote.datasourceimpl

import com.project.movieapp.data.model.MovieResponseDTO
import com.project.movieapp.data.model.MovieDTO
import com.project.movieapp.data.repository.remote.datasource.MovieListRemoteDataSource
import com.project.movieapp.data.util.APIConstants
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter


class MovieListRemoteDataSourceImpl(
    private val httpClient: HttpClient) : MovieListRemoteDataSource {

    override suspend fun getPopularMovieListFromRemote(url: String, page: Int): MovieResponseDTO<List<MovieDTO>> {
        return httpClient.get("${APIConstants.BASE_URL}${url}") {
            parameter("api_key", APIConstants.API_KEY)
        }.body()
    }

}
