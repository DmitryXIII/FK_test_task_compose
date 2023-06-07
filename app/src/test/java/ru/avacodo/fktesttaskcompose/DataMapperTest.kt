package ru.avacodo.fktesttaskcompose

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test
import ru.avacodo.fktesttaskcompose.data.local.entity.FitLessonEntity
import ru.avacodo.fktesttaskcompose.data.mapper.FitDataMapper
import ru.avacodo.fktesttaskcompose.domain.model.FitLesson
import ru.avacodo.fktesttaskcompose.domain.utils.LessonTimeDurationCalculator
import java.text.SimpleDateFormat
import java.util.Locale

class DataMapperTest {
    private val mapper = FitDataMapper(LessonTimeDurationCalculator())
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    private val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

    private val lessonModel = FitLesson(
        name = "lesson",
        date = dateFormat.parse("2023-06-01") ?: error("date parse error"),
        tab = "tab",
        startTime = timeFormat.parse("09:00") ?: error("date parse error"),
        endTime = timeFormat.parse("09:45") ?: error("date parse error"),
        duration = "00:45",
        coachName = "coach",
        place = "place",
        markerColor = "color"

    )

    private val lessonEntity = FitLessonEntity(
        name = "lesson",
        date = "2023-06-01",
        tab = "tab",
        startTime = "09:00",
        endTime = "09:45",
        duration = "00:45",
        coachName = "coach",
        place = "place",
        markerColor = "color"
    )

    @Test
    fun map_from_model_to_entity_success() {
        assertEquals(lessonEntity, mapper.mapToLessonEntity(lessonModel))
    }

    @Test
    fun map_from_model_to_entity_failure() {
        assertFalse(lessonEntity.copy(startTime = "09:41") == mapper.mapToLessonEntity(lessonModel))
    }
}