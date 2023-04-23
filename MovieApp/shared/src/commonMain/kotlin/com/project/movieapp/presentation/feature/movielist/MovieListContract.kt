package com.project.movieapp.presentation.feature.movielist

import com.project.movieapp.base.presentation.ui.BasicUiState
import com.project.movieapp.base.presentation.ui.UiEvent
import com.project.movieapp.base.presentation.ui.UiState
import com.project.movieapp.domain.entity.Movie

interface MovieListContract {
    sealed interface Event : UiEvent {
        data class GetMovies(val page: Int) : Event
    }

    data class State(
        val movies: BasicUiState<List<Movie>>
    ) : UiState
}