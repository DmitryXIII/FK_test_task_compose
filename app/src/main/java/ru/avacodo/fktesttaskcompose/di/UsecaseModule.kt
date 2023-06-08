package ru.avacodo.fktesttaskcompose.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.avacodo.fktesttaskcompose.domain.repository.FitDataRepository
import ru.avacodo.fktesttaskcompose.domain.usecase.GetFitDataUsecase
import ru.avacodo.fktesttaskcompose.domain.usecase.GetFitDataUsecaseImpl
import ru.avacodo.fktesttaskcompose.domain.utils.DateListGenerator
import ru.avacodo.fktesttaskcompose.domain.utils.LessonDateListGenerator
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UsecaseModule {

    @Provides
    @Singleton
    fun provideGetFitDataUsecase(
        repository: FitDataRepository,
        dateListListGenerator: DateListGenerator
    ): GetFitDataUsecase {
        return GetFitDataUsecaseImpl(
            repository = repository,
            dateListListGenerator = dateListListGenerator
        )
    }

    @Provides
    @Singleton
    fun provideDateListGenerator(): DateListGenerator {
        return LessonDateListGenerator()
    }
}