package com.project.movieapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieResponseDTO<T> (
    @SerialName("results")
    val data: T
)