package ru.avacodo.fktesttaskcompose.ui.screens.schedule

import ru.avacodo.fktesttaskcompose.domain.model.FitData

data class FitScheduleScreenState(
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val data: List<FitData> = listOf(),
    val isError: Boolean = false,
    val errorMessage: String = ""
)
