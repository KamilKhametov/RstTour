package com.khametov.rsttour.screens.main.domain.entity

data class PaginationEntity(
    val limit: Int,
    val offset: Int,
    val total: Int,
)