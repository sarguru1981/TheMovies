package com.project.movieapp.data.repository.local.datasource

import com.project.movieapp.domain.entity.Movie

interface MovieListLocalDataSource {

    fun insertMovieListToDB(MovieItem: List<Movie>)
    fun getPopularMovieListFromLocal(): List<Movie>

}