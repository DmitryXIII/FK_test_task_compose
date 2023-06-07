package ru.avacodo.fktesttaskcompose.ui.screens.schedule

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.avacodo.fktesttaskcompose.domain.model.FitData
import ru.avacodo.fktesttaskcompose.domain.model.FitLesson
import ru.avacodo.fktesttaskcompose.domain.model.FitLessonDate

@Preview
@Composable
fun FitScheduleList() {
    val list = mutableListOf<FitData>()

    repeat(10) {
        if (it % 4 == 0) {
            list.add(
                FitLessonDate(
                    date = "среда, ${it + 1} июня"
                )
            )
        } else {
            list.add(
                FitLesson(
                    name = "Персональная тренировка",
                    date = "среда, 11 января",
                    tab = "mea",
                    startTime = "16:45",
                    endTime = "17:45",
                    duration = "1 ч. 00 мин.",
                    coachName = "Мишенин Даниил",
                    place = "Тренажерный зал",
                    markerColor = "#FF0000"
                )
            )
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 12.dp, end = 12.dp)
    ) {
        items(list.size) {
            when (val item = list[it]) {
                is FitLessonDate -> {
                    FitScheduleDateItem(item.date)
                }

                is FitLesson -> {
                    FitScheduleItem(
                        modifier = Modifier.padding(
                            top = 12.dp,
                            bottom = if (it != list.lastIndex) {
                                0.dp
                            } else {
                                12.dp
                            }
                        ),
                        lesson = item
                    )
                }
            }
        }
    }
}