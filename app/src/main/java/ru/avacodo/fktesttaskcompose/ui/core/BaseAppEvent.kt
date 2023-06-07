package ru.avacodo.fktesttaskcompose.ui.core

sealed class BaseAppEvent {
    object Loading : BaseAppEvent()
    object Action : BaseAppEvent()
}
