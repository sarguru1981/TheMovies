package com.project.movieapp.presentation.feature.movielist

import com.project.movieapp.data.util.APIConstants
import com.project.movieapp.domain.entity.Movie
import com.project.movieapp.domain.usecases.MovieListUseCase
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieListViewModel constructor(private val movieListUseCase: MovieListUseCase) : ViewModel() {

    private val moviesMutable =
        MutableStateFlow<MovieListState>(MovieListState.Uninitialized)
    val movies = moviesMutable.asStateFlow()

    private val selectedMovieMutable = MutableStateFlow(Movie())
    val selectedMovie = selectedMovieMutable.asStateFlow()

    init {
        loadMovies()
    }

    fun loadMovies() {
        moviesMutable.value = MovieListState.Loading
        viewModelScope.launch {
            try {
                movieListUseCase.getMovieList(APIConstants.POPULAR_MOVIES, 20).collect{ movies ->
                    moviesMutable.value = MovieListState.Success(movies)
                }

            } catch (e: Exception) {
                e.printStackTrace()
                moviesMutable.value = MovieListState.Error(e.message.orEmpty())
            }
        }
    }

    fun selectMovie(movie: Movie) {
        selectedMovieMutable.value = movie
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}