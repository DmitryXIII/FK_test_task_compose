package ru.avacodo.fktesttaskcompose.ui.screens.schedule

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import ru.avacodo.fktesttaskcompose.ui.screens.LoadingInProgress
import ru.avacodo.fktesttaskcompose.ui.screens.ShowSnack

@Composable
fun FitScheduleScreen(paddingValues: PaddingValues, snackbarHostState: SnackbarHostState) {
    val viewModel: FitScheduleViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val scope = rememberCoroutineScope()

    when (uiState) {
        is FitScheduleScreenState.Loading -> {
            LoadingInProgress(paddingValues)
        }

        else -> {
            SwipeRefresh(
                modifier = Modifier.padding(paddingValues),
                state = rememberSwipeRefreshState(uiState.isRefreshing),
                onRefresh = { viewModel.execute(true) },
            ) {
                FitScheduleList(lessonsList = uiState.data)
            }

            if (uiState.isError) {
                ShowSnack(
                    scope = scope,
                    snackbarHostState = snackbarHostState,
                    message = uiState.errorMessage
                )
            }
        }
    }
}