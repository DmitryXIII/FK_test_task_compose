package ru.avacodo.fktesttaskcompose.domain.usecase

import ru.avacodo.fktesttaskcompose.domain.model.FitData

interface GetFitDataUsecase {
    suspend fun getFitData(): List<FitData>
}