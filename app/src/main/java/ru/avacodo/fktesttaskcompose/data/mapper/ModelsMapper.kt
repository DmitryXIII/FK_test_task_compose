package ru.avacodo.fktesttaskcompose.data.mapper

import ru.avacodo.fktesttaskcompose.data.dto.FitDataDto
import ru.avacodo.fktesttaskcompose.domain.model.FitLesson

interface ModelsMapper {
    fun mapToLessonList(data: FitDataDto): List<FitLesson>
}