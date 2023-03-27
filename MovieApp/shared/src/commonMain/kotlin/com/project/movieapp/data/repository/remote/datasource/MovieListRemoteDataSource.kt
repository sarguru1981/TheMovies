package com.project.movieapp.data.repository.remote.datasource

import com.project.movieapp.data.model.MovieResponseDTO

interface MovieListRemoteDataSource {

    suspend fun getPopularMovieListFromRemote(url: String, page: Int): MovieResponseDTO

}