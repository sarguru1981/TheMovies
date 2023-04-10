package com.project.movieapp.domain.usecases

import com.project.movieapp.data.base.Response
import com.project.movieapp.domain.entity.Movie
import com.project.movieapp.domain.repository.MovieListRepository
import kotlinx.coroutines.flow.Flow

class MovieListUseCase(private val movieListRepository: MovieListRepository) {

    suspend fun getPopularMovieList(url: String, page: Int): Flow<Response<List<Movie>>> {
        return movieListRepository.getPopularMovieList(url, page)
    }
}