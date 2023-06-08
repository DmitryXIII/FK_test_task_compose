package ru.avacodo.fktesttaskcompose.ui.screens.schedule

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ru.avacodo.fktesttaskcompose.ui.core.BaseAppEvent

@Composable
fun FitScheduleScreen() {
    val viewModel: FitScheduleViewModel = hiltViewModel()
    val uiState by remember {
        viewModel.uiState
    }

//    viewModel.execute(BaseAppEvent.Action)

//    LaunchedEffect(key1 = uiState) {
//        viewModel.execute(BaseAppEvent.Loading)
//        viewModel.execute(BaseAppEvent.Action)
//    }

    if (!uiState.isLoading) {
        FitScheduleList(lessonsList = uiState.data)
    } else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}