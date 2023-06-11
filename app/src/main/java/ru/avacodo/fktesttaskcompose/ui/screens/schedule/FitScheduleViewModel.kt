package ru.avacodo.fktesttaskcompose.ui.screens.schedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.avacodo.fktesttaskcompose.domain.model.FitData
import ru.avacodo.fktesttaskcompose.domain.usecase.GetFitDataUsecase
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class FitScheduleViewModel @Inject constructor(
    private val usecase: GetFitDataUsecase
) : ViewModel() {
    private val _uiState =
        MutableStateFlow<FitScheduleScreenState<FitData>>(FitScheduleScreenState.Initial())
    val uiState = _uiState.asStateFlow()

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _uiState.update {
            FitScheduleScreenState.Error(
                errorMessage = throwable.message.toString()
            )
        }
    }

    init {
        execute()
    }

    fun execute(isRefreshing: Boolean = false) {
        if (!isRefreshing) {
            _uiState.tryEmit(FitScheduleScreenState.Loading())
        } else {
            _uiState.tryEmit(
                FitScheduleScreenState.Refreshing<FitData>()
                    .copy(data = _uiState.value.data)
            )
        }

        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            if (Random.nextBoolean()) {
                delay(1000)
                error("Test error")
            } else {
                _uiState.update {
                    FitScheduleScreenState.Success(
                        data = usecase.getFitData(false)
                    )
                }
            }
        }
    }
}