package com.project.movieapp.data.repository.local.datasource

import com.project.movieapp.data.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieListLocalDataSource {

    fun insertMovieListToDB(MovieItem: List<Movie>)
    fun getMovieListFromLocal(): Flow<List<Movie>>

}