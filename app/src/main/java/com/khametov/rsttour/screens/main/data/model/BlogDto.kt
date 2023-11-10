package com.khametov.rsttour.screens.main.data.model

import kotlinx.serialization.Serializable

@Serializable
data class BlogDto(
    val data: List<BlogDataDto>
)