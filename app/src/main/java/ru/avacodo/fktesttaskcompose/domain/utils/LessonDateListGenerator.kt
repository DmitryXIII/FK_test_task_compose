package ru.avacodo.fktesttaskcompose.domain.utils

import ru.avacodo.fktesttaskcompose.domain.model.FitLesson
import ru.avacodo.fktesttaskcompose.domain.model.FitLessonDate

class LessonDateListGenerator : DateListGenerator {
    override fun generateDateList(lessons: List<FitLesson>): List<FitLessonDate> {
        return lessons
            .distinctBy { it.date }
            .map { FitLessonDate(date = it.date) }
            .sortedBy { it.date }
    }
}