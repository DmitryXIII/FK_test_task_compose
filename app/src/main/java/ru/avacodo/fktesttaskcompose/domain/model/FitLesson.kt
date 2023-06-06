package ru.avacodo.fktesttaskcompose.domain.model

import java.util.Date

data class FitLesson(
val name: String,
val date: Date,
val tab: String,
val startTime: Date,
val endTime: Date,
val duration: String,
val coachName: String,
val place: String,
val markerColor: String
): FitData
