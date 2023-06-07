package ru.avacodo.fktesttaskcompose.domain.model

data class FitLesson(
val name: String,
val date: String,
val tab: String,
val startTime: String,
val endTime: String,
val duration: String,
val coachName: String,
val place: String,
val markerColor: String
): FitData
