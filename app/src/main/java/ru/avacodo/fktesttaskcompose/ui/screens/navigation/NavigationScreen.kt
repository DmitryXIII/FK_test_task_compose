package ru.avacodo.fktesttaskcompose.ui.screens.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import ru.avacodo.fktesttaskcompose.ui.screens.EmptyScreen
import ru.avacodo.fktesttaskcompose.ui.screens.schedule.FitScheduleScreen

@SuppressLint("AutoboxingStateValueProperty")
@Composable
fun NavigationScreen() {
    val snackbarHostState = remember { SnackbarHostState() }
    val selectedItem = remember { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = { FKNavigationBar(selectedItem) },
        snackbarHost = { SnackbarHost(snackbarHostState) },
        content = { paddingValues ->
            when (selectedItem.value) {
                0 -> {
                    FitScheduleScreen(
                        padding = paddingValues,
                        snackbarHostState = snackbarHostState
                    )
                }

                else -> {
                    EmptyScreen(content = "Empty screen")
                }
            }
        }
    )
}