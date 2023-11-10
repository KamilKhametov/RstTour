package com.khametov.rsttour.screens.main.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MainTemplateDto(
    @SerialName("object") val type: String
)