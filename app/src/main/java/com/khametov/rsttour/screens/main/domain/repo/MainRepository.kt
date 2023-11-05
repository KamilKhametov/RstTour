package com.khametov.rsttour.screens.main.domain.repo

import com.khametov.rsttour.screens.main.domain.entity.FlightEntity

interface MainRepository {
    suspend fun getFavorites(): List<FlightEntity>
}