package com.khametov.rsttour.screens.main.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class PaginationDto(
    val limit: Int,
    val offset: Int,
    val total: Int
)