package com.project.movieapp.data.mappers

import com.project.movieapp.data.model.MovieDTO
import com.project.movieapp.domain.entity.Movie


fun asDomainMovieEntity(
    id: Long,
    title: String,
    overview: String,
    popularity: Long,
    poster_path: String
): Movie = Movie(id, title, overview, popularity, poster_path)

fun List<MovieDTO>?.asDomainMovieList(): List<Movie>{
    return this?.map { it.asDomainModel() }?: emptyList()
}

/** Convert remote response to [Movie] Domain objects*/
fun MovieDTO.asDomainModel(): Movie {
    return Movie(
        id = id,
        title = originalTitle,
        overview = overview,
        poster_path = posterPath ?: "",
        popularity = popularity.toLong()
    )
}