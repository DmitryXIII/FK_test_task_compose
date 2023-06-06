package ru.avacodo.fktesttaskcompose.domain.model

import java.util.Date

data class FitLesson(
val name: String,
val date: Date,
val tab: String,
val startTime: String,
val endTime: String,
val duration: String,
val coachName: String,
val place: String,
val markerColor: String
)
