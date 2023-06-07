package ru.avacodo.fktesttaskcompose.ui.core

abstract class UiState<T>(
    val isLoading: Boolean,
    val isError: Boolean,
    val data: T,
    val error: String
)