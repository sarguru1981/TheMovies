package com.project.movieapp.data.repository.remote.datasource

import com.project.movieapp.data.model.MovieResponseDTO
import com.project.movieapp.data.model.MovieDTO

interface MovieListRemoteDataSource {

    suspend fun getPopularMovieListFromRemote(url: String, page: Int): MovieResponseDTO<List<MovieDTO>>

}