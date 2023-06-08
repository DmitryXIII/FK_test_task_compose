package ru.avacodo.fktesttaskcompose.ui.screens.schedule

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.launch

@Composable
fun FitScheduleScreen() {
    val viewModel: FitScheduleViewModel = hiltViewModel()
    val uiState = viewModel.uiState.observeAsState(initial = FitScheduleScreenState()).value

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        content = { innerPadding ->
            if (uiState.isError) {
                LaunchedEffect(key1 = uiState) {
                    scope.launch {
                        snackbarHostState.showSnackbar(uiState.errorMessage)
                    }
                }
            } else if (uiState.isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                SwipeRefresh(
                    state = rememberSwipeRefreshState(uiState.isRefreshing),
                    onRefresh = { viewModel.execute(true) },
                ) {
                    FitScheduleList(lessonsList = uiState.data)
                }
            }
        }
    )
}