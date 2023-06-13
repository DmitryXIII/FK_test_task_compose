package ru.avacodo.fktesttaskcompose.ui.core

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<T, V, C: UiState<V>> : ViewModel() {
//    abstract var uiState: MutableState<C>
//
//    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
//        uiState.value = uiState.cop UiState.Error(throwable.message.toString())
//    }
//
//    protected fun execute(event: BaseAppEvent<T>, block: suspend () -> Unit) {
//        when (event) {
//            is BaseAppEvent.Loading -> {
//                uiState.value = UiState.Loading()
//            }
//
//            is BaseAppEvent.Action -> {
//                viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
//                    block.invoke()
//                }
//            }
//        }
//    }
}