package com.project.movieapp.domain.repository

import com.project.movieapp.data.base.Response
import com.project.movieapp.domain.entity.Movie
import kotlinx.coroutines.flow.Flow

interface MovieListRepository {

    suspend fun getPopularMovieList(url: String, page: Int): Flow<Response<List<Movie>>>
}