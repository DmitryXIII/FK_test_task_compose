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
fun FitScheduleList(
    lessonsList: List<FitData> = mutableListOf<FitData>().apply {
        repeat(10) {
            if (it % 4 == 0) {
                add(
                    FitLessonDate(
                        date = "среда, ${it + 1} июня"
                    )
                )
            } else {
                add(
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
    }
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 12.dp, end = 12.dp)
    ) {
        items(lessonsList.size) {
            when (val item = lessonsList[it]) {
                is FitLessonDate -> {
                    FitScheduleDateItem(item.date)
                }

                is FitLesson -> {
                    FitScheduleItem(
                        modifier = Modifier.padding(
                            top = 12.dp,
                            bottom = if (it != lessonsList.lastIndex) {
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