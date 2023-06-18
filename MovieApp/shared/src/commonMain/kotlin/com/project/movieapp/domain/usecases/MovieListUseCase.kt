package com.project.movieapp.domain.usecases

import com.project.movieapp.domain.entity.Movie
import com.project.movieapp.data.repository.MovieListRepository
import kotlinx.coroutines.flow.Flow

class MovieListUseCase(private val movieListRepository: MovieListRepository) {
    fun getMovieList(url: String, page: Int): Flow<List<Movie>> {
        return movieListRepository.getPopularMovieList(url, page)
    }
 }