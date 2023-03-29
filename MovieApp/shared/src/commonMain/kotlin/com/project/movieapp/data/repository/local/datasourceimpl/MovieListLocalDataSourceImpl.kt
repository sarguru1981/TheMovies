package com.project.movieapp.data.repository.local.datasourceimpl

import com.project.movie.database.MovieDatabase
import com.project.movieapp.data.factory.DriverFactory
import com.project.movieapp.data.mappers.asDomainMovieEntity
import com.project.movieapp.domain.entity.Movie
import com.project.movieapp.data.repository.local.datasource.MovieListLocalDataSource


class MovieListLocalDataSourceImpl(
    driverFactory: DriverFactory) : MovieListLocalDataSource {

    private val database =
        MovieDatabase.invoke(driverFactory.createDriver())
    private val queries = database.movieDatabaseQueries

    override fun insertMovieListToDB(movies: List<Movie>) {
        for (movie in movies) {
            queries.transaction {
                queries.insertMovielist(
                    id = movie.id,
                    title = movie.title,
                    overview = movie.overview,
                    popularity = movie.popularity,
                    poster_path = movie.poster_path
                )
            }
        }
    }

    override fun getPopularMovieListFromLocal(): List<Movie> {
        return queries.getMovielist(::asDomainMovieEntity).executeAsList()
    }
}
