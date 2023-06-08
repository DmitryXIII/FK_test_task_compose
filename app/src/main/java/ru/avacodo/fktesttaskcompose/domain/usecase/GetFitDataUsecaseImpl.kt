package ru.avacodo.fktesttaskcompose.domain.usecase

import ru.avacodo.fktesttaskcompose.domain.model.FitData
import ru.avacodo.fktesttaskcompose.domain.repository.FitDataRepository
import ru.avacodo.fktesttaskcompose.domain.utils.DateListGenerator
import java.text.SimpleDateFormat
import java.util.Locale

private const val TIME_FORMAT_PATTERN = "HH:mm"

class GetFitDataUsecaseImpl(
    private val repository: FitDataRepository,
    private val dateListListGenerator: DateListGenerator
) : GetFitDataUsecase {
    private val outcomeDateFormatter = SimpleDateFormat(TIME_FORMAT_PATTERN, Locale.getDefault())
    override suspend fun getFitData(isDataFromCashRequired: Boolean): List<FitData> {
        val lessons = if (!isDataFromCashRequired) {
            repository.getRemoteFitData()
        } else {
            repository.getLocalFitData()
        }

        val dates = dateListListGenerator.generateDateList(lessons)
        return mutableListOf<FitData>().apply {
            dates.forEach { fitDate ->
                add(fitDate)
                lessons
                    .filter { it.date == fitDate.date }
                    .sortedBy { outcomeDateFormatter.parse(it.startTime) }
                    .forEach { lesson ->
                        add(lesson)
                    }
            }
        }
    }
}