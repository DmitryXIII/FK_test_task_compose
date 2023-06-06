package ru.avacodo.fktesttaskcompose.domain.repository

import ru.avacodo.fktesttaskcompose.domain.model.FitLesson

interface FitDataRepository {
    suspend fun getFitLocalData(): List<FitLesson>
    suspend fun getFitRemoteData(): List<FitLesson>
}