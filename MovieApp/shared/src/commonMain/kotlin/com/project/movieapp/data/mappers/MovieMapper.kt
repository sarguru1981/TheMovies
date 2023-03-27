package com.project.movieapp.data.mappers

import com.project.movieapp.domain.entity.Movie


fun asDomainMovieEntity(
    id: Long,
    title: String,
    overview: String,
    popularity: Long,
    poster_path: String
): Movie = Movie(id, title, overview, popularity, poster_path)
