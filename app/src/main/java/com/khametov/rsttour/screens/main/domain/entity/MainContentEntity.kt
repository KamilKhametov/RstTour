package com.khametov.rsttour.screens.main.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class MainContentEntity(
    val title: String,
    val template: MainTemplateEntity,
    val url: String
)