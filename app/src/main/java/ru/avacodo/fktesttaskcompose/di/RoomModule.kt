package ru.avacodo.fktesttaskcompose.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.avacodo.fktesttaskcompose.data.local.FitDao
import ru.avacodo.fktesttaskcompose.data.local.FitDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun provideLocalDatabase(app: Application): FitDao {
        return Room.databaseBuilder(
            app,
            FitDatabase::class.java,
            "fit_db"
        ).build().fitDao
    }
}