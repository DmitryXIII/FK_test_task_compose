package ru.avacodo.fktesttaskcompose.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FitLessonEntity(
    @PrimaryKey(autoGenerate = true)
    val ID: Int = 0,
    val appointmentID: String,
    val availableSlots: Int,
    val clientRecorded: Boolean,
    val coachName: String,
    val color: String,
    val commercial: Boolean,
    val date: String,
    val description: String,
    val endTime: String,
    val isCancelled: Boolean,
    val name: String,
    val place: String,
    val serviceID: String,
    val startTime: String,
    val tab: String,
    val tabID: Int
)
