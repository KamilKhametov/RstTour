package com.khametov.rsttour.screens.main.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class MainDataEntity(
    val content: List<MainContentEntity>
)