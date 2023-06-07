package ru.avacodo.fktesttaskcompose.ui.screens.schedule

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun FitScheduleDateItem(
    date: String = "среда, 16 июня"
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 12.dp, top = 32.dp)) {
        Text(text = date)
    }
}
