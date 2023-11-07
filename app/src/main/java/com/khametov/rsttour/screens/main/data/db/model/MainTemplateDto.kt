package com.khametov.rsttour.screens.main.data.db.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MainTemplateDto(
    @SerialName("object") val type: String
)