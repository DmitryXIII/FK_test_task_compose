package ru.avacodo.fktesttaskcompose.data.mapper

import ru.avacodo.fktesttaskcompose.data.dto.FitDataDto
import ru.avacodo.fktesttaskcompose.data.local.entity.FitLessonEntity
import ru.avacodo.fktesttaskcompose.domain.model.FitLesson

interface ModelsMapper {
    fun mapToLessonList(data: FitDataDto): List<FitLesson>
    fun mapEntityToLesson(lessonEntity: FitLessonEntity): FitLesson
    fun mapToLessonEntityList(data: FitDataDto): List<FitLessonEntity>
}