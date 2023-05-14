package com.project.movieapp.presentation.feature.movielist

import com.project.movieapp.domain.entity.Movie

sealed interface MovieListState {
    data class Success(val data: List<Movie>) : MovieListState
    data class Error(val exceptionMessage: String) : MovieListState
    object Loading : MovieListState
    object Uninitialized : MovieListState
}