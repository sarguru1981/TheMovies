package com.project.movieapp.data.repository.local.datasourceimpl

import com.project.movie.database.MovieDatabase
import com.project.movieapp.data.mappers.asDomainMovieEntity
import com.project.movieapp.domain.entity.Movie
import com.project.movieapp.data.repository.local.datasource.MovieListLocalDataSource


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

    override fun getPopularMovieListFromLocal(): List<Movie> {
        return queries.getMovielist(::asDomainMovieEntity).executeAsList()
    }
}
