package ru.avacodo.fktesttaskcompose.data.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.avacodo.fktesttaskcompose.data.local.entity.FitLessonEntity

interface FitDao {

    @Query("SELECT * FROM FitLessonEntity")
    suspend fun getFromCash(): List<FitLessonEntity>

    @Query("DELETE FROM FitLessonEntity")
    suspend fun clearCash()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToCash(lessonsList: List<FitLessonEntity>)
}