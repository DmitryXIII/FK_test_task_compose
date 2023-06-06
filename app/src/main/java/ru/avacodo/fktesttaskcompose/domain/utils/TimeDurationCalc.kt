package ru.avacodo.fktesttaskcompose.domain.utils

interface TimeDurationCalc {
    fun calcTimeDuration(startTime: String, endTime: String): String
}