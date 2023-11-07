package com.khametov.rsttour.screens.main.domain.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MainTemplateEntity(
    @SerialName("object") val type: String
)