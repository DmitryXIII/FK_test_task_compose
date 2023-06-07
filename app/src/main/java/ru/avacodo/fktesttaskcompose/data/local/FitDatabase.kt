package ru.avacodo.fktesttaskcompose.data.local

import androidx.room.Database
import ru.avacodo.fktesttaskcompose.data.local.entity.FitLessonEntity

@Database(
    entities = [FitLessonEntity::class],
    version = 1
)
abstract class FitDatabase {
    abstract val fitDao: FitDao
}