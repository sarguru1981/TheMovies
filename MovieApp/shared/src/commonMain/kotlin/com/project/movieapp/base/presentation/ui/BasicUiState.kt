package com.project.movieapp.base.presentation.ui

sealed interface BasicUiState<out T> {
    data class Success<T>(val data: T) : BasicUiState<T>
    data class Error(val message: String? = null) : BasicUiState<Nothing>
    object Loading : BasicUiState<Nothing>
    object Empty : BasicUiState<Nothing>
    object Idle : BasicUiState<Nothing>
}
