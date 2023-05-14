package com.project.movieapp.data.repository

import com.project.movieapp.data.mappers.MovieDataMapper
import com.project.movieapp.data.repository.cache.PreferenceDataStore
import com.project.movieapp.data.repository.local.datasource.MovieListLocalDataSource
import com.project.movieapp.data.repository.remote.datasource.MovieListRemoteDataSource
import com.project.movieapp.domain.entity.Movie
import com.project.movieapp.domain.repository.MovieListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.flow

class MovieListRepositoryImpl(
    private val movieListRemoteDataSource: MovieListRemoteDataSource,
    private val movieListLocalDataSource: MovieListLocalDataSource,
    private val preferenceDataStore: PreferenceDataStore,
    private val dataMapper: MovieDataMapper
) : MovieListRepository {

    override fun getPopularMovieList(url: String, page: Int): Flow<List<Movie>> =
        singleSourceOfTruth(
            getLocalData = { getPopularMovieListFromLocal() },
            getRemoteData = {
                movieListRemoteDataSource.getPopularMovieListFromRemote(url, page).data.map {
                    dataMapper.mapMovieResponse(it)
                }
            },
            saveDataToLocal = { movieList ->
                movieListLocalDataSource.deleteMovieListFromDB()
                movieListLocalDataSource.insertMovieListToDB(movieList)
                preferenceDataStore.put(CacheConstants.DATASTORE_MOVIE_LIST_KEY, movieList)
            }
        )

    private suspend fun getPopularMovieListFromLocal(): List<Movie> {
        var movieList: List<Movie> = emptyList()
        val movieListFlow: Flow<List<Movie>> =
            preferenceDataStore.getListData(CacheConstants.DATASTORE_MOVIE_LIST_KEY)
        /*movieListFlow.cancellable().collect {
            movieList = it
        }*/
        if (movieList.isEmpty()) {
            movieList = movieListLocalDataSource.getPopularMovieListFromLocal()
            if (movieList.isNotEmpty()) {
                this.preferenceDataStore.put(CacheConstants.DATASTORE_MOVIE_LIST_KEY, movieList)
            }
        }
        return movieList
    }
}