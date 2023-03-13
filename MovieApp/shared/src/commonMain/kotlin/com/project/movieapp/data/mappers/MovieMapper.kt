package com.project.movieapp.data.mappers

import com.project.movieapp.data.model.Movie


fun mapToMovieItem(
    id: Long,
    title: String,
    overview: String,
    popularity: Long,
    poster_path: String
): Movie = Movie(id, title, overview, popularity, poster_path)
