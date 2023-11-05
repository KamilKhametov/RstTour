package com.khametov.rsttour.screens.main.data.network.api

import com.khametov.rsttour.screens.main.data.network.dto.RTFlightsResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MainRestApi {

    @GET("flights")
    suspend fun getRealTimeFlights(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = 20,
    ): RTFlightsResponseDto
}