package com.khametov.rsttour.screens.main.data.db.model

import kotlinx.serialization.Serializable

@Serializable
data class MainContentDto(
    val title: String,
    val template: MainTemplateDto,
    val url: String
)