package ru.avacodo.fktesttaskcompose.ui.screens.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import ru.avacodo.fktesttaskcompose.ui.screens.schedule.FitScheduleScreen

@Composable
fun NavigationScreen() {
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        bottomBar = { FKNavigationBar() },
        snackbarHost = { SnackbarHost(snackbarHostState) },
        content = { innerPadding ->
            FitScheduleScreen(padding = innerPadding, snackbarHostState = snackbarHostState)
        }
    )
}