package ru.avacodo.fktesttaskcompose.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FitLessonEntity(
    @PrimaryKey(autoGenerate = true)
    val ID: Int = 0,
    val name: String,
    val date: String,
    val tab: String,
    val startTime: String,
    val endTime: String,
    val duration: String,
    val coachName: String,
    val place: String,
    val markerColor: String
)
