package ru.avacodo.fktesttaskcompose.ui.screens.schedule

import ru.avacodo.fktesttaskcompose.domain.model.FitData

sealed class FitScheduleScreenState<T> {
    abstract val isLoading: Boolean
    abstract val isRefreshing: Boolean
    abstract val data: List<T>
    abstract val isError: Boolean
    abstract val errorMessage: String

    data class Initial<T>(
        override val isLoading: Boolean = false,
        override val isRefreshing: Boolean = false,
        override val data: List<T> = listOf(),
        override val isError: Boolean = false,
        override val errorMessage: String = ""
    ) : FitScheduleScreenState<T>()

    data class Refreshing<T>(
        override val isLoading: Boolean = false,
        override val isRefreshing: Boolean = true,
        override val data: List<T> = listOf(),
        override val isError: Boolean = false,
        override val errorMessage: String = ""
    ) : FitScheduleScreenState<T>()

    data class Loading<T>(
        override val isLoading: Boolean = true,
        override val isRefreshing: Boolean = false,
        override val data: List<T> = listOf(),
        override val isError: Boolean = false,
        override val errorMessage: String = ""
    ) : FitScheduleScreenState<T>()

    data class Error<T>(
        override val isLoading: Boolean = false,
        override val isRefreshing: Boolean = false,
        override val data: List<T> = listOf(),
        override val isError: Boolean = true,
        override val errorMessage: String
    ) : FitScheduleScreenState<T>()

    data class Success<T>(
        override val isLoading: Boolean = false,
        override val isRefreshing: Boolean = false,
        override val data: List<T>,
        override val isError: Boolean = false,
        override val errorMessage: String = ""
    ) : FitScheduleScreenState<T>()
}


