package ru.avacodo.fktesttaskcompose.domain.usecase

import ru.avacodo.fktesttaskcompose.domain.model.FitData
import ru.avacodo.fktesttaskcompose.domain.repository.FitDataRepository
import ru.avacodo.fktesttaskcompose.domain.utils.DateListGenerator

class GetFitDataUsecaseImpl(
    private val repository: FitDataRepository,
    private val dateListListGenerator: DateListGenerator
) : GetFitDataUsecase {
    override suspend fun getFitData(): List<FitData> {
        val lessons = repository.getFitRemoteData()
        val dates = dateListListGenerator.generateDateList(lessons)
        return mutableListOf<FitData>().apply {
            dates.forEach { fitDate ->
                add(fitDate)
                lessons
                    .filter { it.date == fitDate.date }
                    .sortedBy { it.startTime }
                    .forEach { lesson ->
                    add(lesson)
                }
            }
        }
    }
}