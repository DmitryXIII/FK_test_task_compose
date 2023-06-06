package ru.avacodo.fktesttaskcompose.data.remote

import retrofit2.http.GET
import retrofit2.http.Query
import ru.avacodo.fktesttaskcompose.data.dto.FitDataDto

private const val GET_VALUE = "schedule/get_v3"
private const val QUERY_CLUB_ID = "club_id"
private const val DEFAULT_CLUB_ID = 2

interface FitDataApi {
    @GET(GET_VALUE)
    fun getFitData(
        @Query(QUERY_CLUB_ID) clubID: Int = DEFAULT_CLUB_ID
    ): FitDataDto
}