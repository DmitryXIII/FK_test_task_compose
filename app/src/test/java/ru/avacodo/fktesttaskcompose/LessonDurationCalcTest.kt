package ru.avacodo.fktesttaskcompose

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test
import ru.avacodo.fktesttaskcompose.domain.utils.LessonTimeDurationCalculator
import java.text.ParseException

class LessonDurationCalcTest {
    private val calculator = LessonTimeDurationCalculator()

    @Test
    fun calculate_duration_success() {
        val startTime = "09:00"
        val endTime = "09:45"
        val duration = calculator.calcTimeDuration(startTime, endTime)
        assertEquals("0 ч. 45 мин.", duration)
    }

    @Test
    fun calculate_duration_fail() {
        val startTime = "09:01"
        val endTime = "09:45"
        val duration = calculator.calcTimeDuration(startTime, endTime)
        assertFalse("0 ч. 45 мин." == duration)
    }

    @Test(expected = IllegalStateException::class)
    fun calculate_duration_when_start_time_is_bigger() {
        val startTime = "09:45"
        val endTime = "09:00"
        val duration = calculator.calcTimeDuration(startTime, endTime)
        assertEquals("0 ч. 45 мин.", duration)
    }

    @Test(expected = ParseException::class)
    fun calculate_duration_when_invalid_time_format() {
        val startTime = "09.45"
        val endTime = "09:00"
        val duration = calculator.calcTimeDuration(startTime, endTime)
        assertEquals("0 ч. 45 мин.", duration)
    }
}