package com.project.movieapp.domain.usecases

import com.project.movieapp.data.util.APIConstants
import com.project.movieapp.base.domain.UseCaseOutFlow
import com.project.movieapp.domain.entity.Movie
import com.project.movieapp.domain.repository.MovieListRepository
import kotlinx.coroutines.flow.Flow

class MovieListUseCase(
    private val movieListRepository: MovieListRepository,
    override val block: suspend (Int) -> Flow<List<Movie>> = { movieListRepository.getPopularMovieList(APIConstants.POPULAR_MOVIES, it) },
) : UseCaseOutFlow<Int, List<Movie>>()