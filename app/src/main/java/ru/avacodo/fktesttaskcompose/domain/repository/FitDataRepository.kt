package ru.avacodo.fktesttaskcompose.domain.repository

import ru.avacodo.fktesttaskcompose.domain.model.FitLesson

interface FitDataRepository {
    suspend fun getLocalFitData(): List<FitLesson>
    suspend fun getRemoteFitData(): List<FitLesson>
    suspend fun addToCash(lessons: List<FitLesson>)
    suspend fun clearCash()
}