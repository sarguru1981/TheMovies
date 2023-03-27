package com.project.movieapp.domain.entity

data class Movie(
    val id: Long?,
    val title: String,
    val overview: String,
    val popularity: Long,
    val poster_path: String
)
