package ru.avacodo.fktesttaskcompose.ui.screens.schedule

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.avacodo.fktesttaskcompose.domain.usecase.GetFitDataUsecase
import ru.avacodo.fktesttaskcompose.ui.core.BaseAppEvent

class FitScheduleViewModel(private val usecase: GetFitDataUsecase) : ViewModel() {
    val uiState = mutableStateOf(FitScheduleScreenState())

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        uiState.value = uiState.value.copy(
            isError = true,
            errorMessage = throwable.message.toString()
        )
    }

    fun execute(event: BaseAppEvent) {
        when (event) {
            BaseAppEvent.Action -> {
                viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
                    val result = usecase.getFitData(false)
                    uiState.value = uiState.value.copy(
                        isError = false,
                        errorMessage = "",
                        isLoading = false,
                        data = result
                    )
                }
            }

            BaseAppEvent.Loading -> {
                uiState.value = uiState.value.copy(
                    isError = false,
                    errorMessage = "",
                    isLoading = true,
                )
            }
        }
    }
}