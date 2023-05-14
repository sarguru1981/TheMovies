package com.project.movieapp.data.mappers

import com.project.movieapp.data.model.MovieDTO
import com.project.movieapp.domain.entity.Movie


class MovieDataMapper {

    fun mapMovieResponse(response: MovieDTO) = Movie(
        id = response.id,
        title = response.originalTitle,
        overview = response.overview,
        poster_path = buildString {
            append("https://image.tmdb.org/t/p/w600_and_h900_bestv2")
            append(response.posterPath.orEmpty())
        },
        popularity = response.popularity,
    )
}

fun asDomainMovieEntity(
    id: Long,
    title: String,
    overview: String,
    popularity: Long,
    poster_path: String
): Movie = Movie(id, title, overview, poster_path, popularity.toDouble())
