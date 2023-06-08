package ru.avacodo.fktesttaskcompose.ui.screens.schedule

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.avacodo.fktesttaskcompose.domain.usecase.GetFitDataUsecase
import javax.inject.Inject

@HiltViewModel
class FitScheduleViewModel @Inject constructor(
    private val usecase: GetFitDataUsecase
) : ViewModel() {
    val uiState = mutableStateOf(FitScheduleScreenState())

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        uiState.value = uiState.value.copy(
            isError = true,
            errorMessage = throwable.message.toString()
        )
    }

    init {
        execute()
    }

    fun execute() {
        viewModelScope.launch(Dispatchers.IO ) {
            Log.d("@#@", "execute before: +++++++++++++++++++++++")
            val result = usecase.getFitData(false)
            Log.d("@#@", "execute: +++++++++++++++++++++++")
            Log.d("@#@", "${result}")
            Log.d("@#@", "${uiState.value}")
            uiState.value = uiState.value.copy(
                isError = false,
                errorMessage = "",
                isLoading = false,
                data = result
            )
        }
//        when (event) {
//            BaseAppEvent.Action -> {
//                viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
//                    Log.d("@#@", "execute before: +++++++++++++++++++++++")
//                    val result = usecase.getFitData(false)
//                    Log.d("@#@", "execute: +++++++++++++++++++++++")
//                    uiState.value = uiState.value.copy(
//                        isError = false,
//                        errorMessage = "",
//                        isLoading = false,
//                        data = result
//                    )
//                }
//            }
//
//            BaseAppEvent.Loading -> {
//                uiState.value = uiState.value.copy(
//                    isError = false,
//                    errorMessage = "",
//                    isLoading = true,
//                )
//            }
//        }
    }
}