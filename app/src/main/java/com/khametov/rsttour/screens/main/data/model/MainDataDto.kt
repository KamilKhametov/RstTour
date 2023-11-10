package com.khametov.rsttour.screens.main.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MainDataDto(
    val content: List<MainContentDto>
)