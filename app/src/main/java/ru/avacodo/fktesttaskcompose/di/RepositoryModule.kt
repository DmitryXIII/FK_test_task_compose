package ru.avacodo.fktesttaskcompose.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.avacodo.fktesttaskcompose.data.local.FitDao
import ru.avacodo.fktesttaskcompose.data.mapper.FitDataMapper
import ru.avacodo.fktesttaskcompose.data.mapper.ModelsMapper
import ru.avacodo.fktesttaskcompose.data.remote.FitDataApi
import ru.avacodo.fktesttaskcompose.data.repository.FitDataRepositoryImpl
import ru.avacodo.fktesttaskcompose.domain.repository.FitDataRepository
import ru.avacodo.fktesttaskcompose.domain.utils.LessonTimeDurationCalculator
import ru.avacodo.fktesttaskcompose.domain.utils.TimeDurationCalc
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideFitDataRepository(
        remoteDataSource: FitDataApi,
        localDataSource: FitDao,
        dataMapper: ModelsMapper
    ): FitDataRepository {
        return FitDataRepositoryImpl(
            remoteDataSource = remoteDataSource,
            localDataSource = localDataSource,
            dataMapper = dataMapper
        )
    }

    @Provides
    @Singleton
    fun provideModelsMapper(durationCalc: TimeDurationCalc): ModelsMapper {
        return FitDataMapper(durationCalc)
    }

    @Provides
    @Singleton
    fun provideTimeDurationCalc(): TimeDurationCalc {
        return LessonTimeDurationCalculator()
    }
}