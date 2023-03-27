package com.project.movieapp.data.model

import com.project.movieapp.data.mappers.asDomainMovieList
import com.project.movieapp.domain.entity.Movie
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieResponseDTO(
    @SerialName(value = "results") val movieList: List<MovieDTO>?,
    @SerialName(value = "page") val page: Int?,
    @SerialName(value = "status_message") val message: String?,
    @SerialName(value = "total_pages") val totalPages: Int?,
) {
    /**To help SwiftUI*/
    val movieDataList : List<Movie> get() = movieList.asDomainMovieList()

    companion object {
        val mocked = MovieResponseDTO(listOf(MovieDTO.mocked),1,null, 1)
    }
}
