package ru.avacodo.fktesttaskcompose.ui.screens.schedule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
    private val _uiState = MutableLiveData(FitScheduleScreenState())
    val uiState: LiveData<FitScheduleScreenState> = _uiState

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _uiState.postValue(
            _uiState.value?.copy(
                isError = true,
                errorMessage = throwable.message.toString()
            )
        )
    }

    init {
        execute()
    }

    private fun execute() {
        _uiState.postValue(
            _uiState.value?.copy(
                isError = false,
                isLoading = true,
            )
        )
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            _uiState.postValue(
                _uiState.value?.copy(
                    isError = false,
                    errorMessage = "",
                    isLoading = false,
                    data = usecase.getFitData(false)
                )
            )
        }
    }
}