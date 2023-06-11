package ru.avacodo.fktesttaskcompose.ui.screens.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.avacodo.fktesttaskcompose.ui.screens.EmptyScreen
import ru.avacodo.fktesttaskcompose.ui.screens.schedule.FitScheduleScreen

@SuppressLint("AutoboxingStateValueProperty")
@Composable
fun NavigationScreen() {
    val snackbarHostState = remember { SnackbarHostState() }
    val selectedItem = remember { mutableIntStateOf(0) }
    var title by remember { mutableStateOf("") }

    Scaffold(
        topBar = { FKTopBar(title) },
        bottomBar = { FKNavigationBar(selectedItem) },
        snackbarHost = { SnackbarHost(snackbarHostState) },
        content = { paddingValues ->
            when (selectedItem.value) {
                0 -> {
                    title = FKNavigationBarItems.SCHEDULE.title
                    FitScheduleScreen(
                        padding = paddingValues,
                        snackbarHostState = snackbarHostState
                    )
                }

                else -> {
                    title = "Empty screen"
                    EmptyScreen(content = "Empty screen")
                }
            }
        }
    )
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FKTopBar(title: String = "Title") {
    Surface(shadowElevation = 2.dp) {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFF6F6F6)),
            title = {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            },
        )
    }
}