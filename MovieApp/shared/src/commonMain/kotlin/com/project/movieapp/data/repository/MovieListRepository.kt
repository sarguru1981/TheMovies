package com.project.movieapp.data.repository

import com.project.movieapp.domain.entity.Movie
import kotlinx.coroutines.flow.Flow

interface MovieListRepository {

    fun getPopularMovieList(url: String, page: Int): Flow<List<Movie>>
}