package com.khametov.rsttour.screens.main.domain.entity

import com.khametov.rsttour.screens.main.domain.entity.FlightEntity
import com.khametov.rsttour.screens.main.domain.entity.PaginationEntity

data class RTFlightsEntity(
    val flights: List<FlightEntity>,
    val pagination: PaginationEntity,
)