package com.khametov.rsttour.screens.main.data.db.model

import kotlinx.serialization.Serializable

@Serializable
data class BlogDto(
    val data: List<BlogDataDto>
)