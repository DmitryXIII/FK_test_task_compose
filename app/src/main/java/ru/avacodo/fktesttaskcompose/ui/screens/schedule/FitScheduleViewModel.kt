package ru.avacodo.fktesttaskcompose.ui.screens.schedule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.avacodo.fktesttaskcompose.domain.model.FitData
import ru.avacodo.fktesttaskcompose.domain.usecase.GetFitDataUsecase
import javax.inject.Inject

@HiltViewModel
class FitScheduleViewModel @Inject constructor(
    private val usecase: GetFitDataUsecase
) : ViewModel() {
    private val _uiState = MutableLiveData<FitScheduleScreenState<FitData>>()
    val uiState: LiveData<FitScheduleScreenState<FitData>> = _uiState

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _uiState.postValue(
            FitScheduleScreenState.Error(
                errorMessage = throwable.message.toString()
            )
        )
    }

    init {
        execute()
    }

    fun execute(isRefreshing: Boolean = false) {
        if (!isRefreshing) {
            _uiState.postValue(FitScheduleScreenState.Loading())
        } else {
            _uiState.postValue(
                FitScheduleScreenState.Refreshing<FitData>()
                    .copy(data = _uiState.value?.data ?: listOf())
            )
        }

        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            _uiState.postValue(
                FitScheduleScreenState.Success(
                    data = usecase.getFitData(false)
                )
            )
        }
    }
}