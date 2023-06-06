package ru.avacodo.fktesttaskcompose.domain.utils

import ru.avacodo.fktesttaskcompose.domain.model.FitLesson
import ru.avacodo.fktesttaskcompose.domain.model.FitLessonDate

interface DateListGenerator {
    fun generateDateList(lessons: List<FitLesson>): List<FitLessonDate>
}