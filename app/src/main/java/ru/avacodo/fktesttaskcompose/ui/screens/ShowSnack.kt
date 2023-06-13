package ru.avacodo.fktesttaskcompose.ui.screens

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ShowSnack(scope: CoroutineScope, snackbarHostState: SnackbarHostState, message: String) {
    LaunchedEffect(key1 = message) {
        scope.launch {
            snackbarHostState.showSnackbar(message)
        }
    }
}