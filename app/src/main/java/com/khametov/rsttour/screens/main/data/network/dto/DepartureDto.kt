package com.khametov.rsttour.screens.main.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class DepartureDto(
    val timezone: String?,
    val estimated: String
)
