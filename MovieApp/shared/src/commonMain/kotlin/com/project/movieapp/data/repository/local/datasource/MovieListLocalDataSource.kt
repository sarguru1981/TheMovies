package com.project.movieapp.data.repository.local.datasource

import com.project.movieapp.domain.entity.Movie

interface MovieListLocalDataSource {

    fun insertMovieListToDB(movies: List<Movie>)

    fun deleteMovieListFromDB()

    fun getPopularMovieListFromLocal(): List<Movie>

}