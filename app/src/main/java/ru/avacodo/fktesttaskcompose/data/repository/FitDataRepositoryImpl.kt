package ru.avacodo.fktesttaskcompose.data.repository

import ru.avacodo.fktesttaskcompose.data.local.FitDao
import ru.avacodo.fktesttaskcompose.data.mapper.ModelsMapper
import ru.avacodo.fktesttaskcompose.data.remote.FitDataApi
import ru.avacodo.fktesttaskcompose.domain.model.FitLesson
import ru.avacodo.fktesttaskcompose.domain.repository.FitDataRepository

class FitDataRepositoryImpl(
    private val remoteDataSource: FitDataApi,
    private val localDataSource: FitDao,
    private val dataMapper: ModelsMapper
) : FitDataRepository {
    override suspend fun getLocalFitData(): List<FitLesson> {
        val remoteData = dataMapper.mapToLessonList(remoteDataSource.getFitData())
        return remoteData.also {
            localDataSource.let {
                clearCash()
                addToCash(remoteData)
            }
        }
    }

    override suspend fun getRemoteFitData(): List<FitLesson> {
        return localDataSource.getFromCash().map {
            dataMapper.mapEntityToLesson(it)
        }
    }

    override suspend fun addToCash(lessons: List<FitLesson>) {
        localDataSource.addToCash(lessons.map {
            dataMapper.mapToLessonEntity(it)
        })
    }

    override suspend fun clearCash() {
        localDataSource.clearCash()
    }
}