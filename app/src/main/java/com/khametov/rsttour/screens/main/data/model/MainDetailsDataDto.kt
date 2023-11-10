package com.khametov.rsttour.screens.main.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MainDetailsDataDto(
    val title: String,
    val subtitle: String,
    val date: String,
    val content: String
)