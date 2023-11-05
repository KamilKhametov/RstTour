package com.khametov.rsttour.screens.main.data.network.dto

import com.khametov.rsttour.screens.main.data.network.dto.FlightDto
import com.khametov.rsttour.screens.main.data.network.dto.PaginationDto
import kotlinx.serialization.Serializable

@Serializable
data class RTFlightsResponseDto(
    val pagination: PaginationDto,
    val data: List<FlightDto>,
)