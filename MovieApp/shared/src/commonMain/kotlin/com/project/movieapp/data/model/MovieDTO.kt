package com.project.movieapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDTO(
    @SerialName("id") val id: Long,
    @SerialName("original_title") val originalTitle: String,
    @SerialName("overview") val overview: String,
    @SerialName("poster_path") val posterPath: String? = null,
    @SerialName("popularity") val popularity: Double,
) {
    companion object {
        val mocked = MovieDTO(1L, "title", "overview", "path", 3697.165)
    }
}