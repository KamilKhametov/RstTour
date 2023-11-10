package com.khametov.rsttour.screens.main.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MainContentDto(
    val title: String,
    val template: MainTemplateDto,
    val url: String
)