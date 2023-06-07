package ru.avacodo.fktesttaskcompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.avacodo.fktesttaskcompose.data.local.entity.FitLessonEntity

@Database(
    entities = [FitLessonEntity::class],
    version = 1
)
abstract class FitDatabase: RoomDatabase() {
    abstract val fitDao: FitDao
}