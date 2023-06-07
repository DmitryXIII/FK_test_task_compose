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
    override suspend fun getFitLocalData(): List<FitLesson> {
        return dataMapper.mapToLessonList(remoteDataSource.getFitData())
    }

    override suspend fun getFitRemoteData(): List<FitLesson> {
        return localDataSource.getFromCash().map {
            dataMapper.mapEntityToLesson(it)
        }
    }
}