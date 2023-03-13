package com.project.movieapp.data.repository.local.datasourceimpl

import com.project.movie.database.MovieDatabase
import com.project.movieapp.data.mappers.mapToMovieItem
import com.project.movieapp.data.model.Movie
import com.project.movieapp.data.repository.local.datasource.MovieListLocalDataSource
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.Flow


class MovieListLocalDataSourceImpl(MovieDatabase: MovieDatabase) : MovieListLocalDataSource {
    private val queries = MovieDatabase.movieDatabaseQueries

    override fun insertMovieListToDB(movieList: List<Movie>) {
        for (movieItem in movieList) {
            queries.transaction {
                queries.insertMovielist(
                    id = movieItem.id,
                    title = movieItem.title,
                    overview = movieItem.overview,
                    popularity = movieItem.popularity.toLong(),
                    poster_path = movieItem.poster_path
                )
            }
        }
    }

    override fun getMovieListFromLocal(): Flow<List<Movie>> {
        return queries.getMovielist(::mapToMovieItem).asFlow().mapToList()
    }
}
