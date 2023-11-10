package com.khametov.rsttour.screens.main.data.model

import kotlinx.serialization.Serializable

@Serializable
data class BlogImageDto(
    val sm: String,
    val md: String,
    val lg: String
)