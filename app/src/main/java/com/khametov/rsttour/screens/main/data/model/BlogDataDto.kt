package com.khametov.rsttour.screens.main.data.model

import kotlinx.serialization.Serializable

@Serializable
data class BlogDataDto(
    val id: Int,
    val image: BlogImageDto,
    val title: String,
    val subtitle: String
)