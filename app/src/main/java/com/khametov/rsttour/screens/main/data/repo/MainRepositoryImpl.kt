package com.khametov.rsttour.screens.main.data.repo

import com.khametov.rsttour.common.base.BaseMapper
import com.khametov.rsttour.screens.main.data.db.FavoritesDataSource
import com.khametov.rsttour.screens.main.data.db.dto.FlightLocalDto
import com.khametov.rsttour.screens.main.data.network.api.MainRestApi
import com.khametov.rsttour.screens.main.data.network.dto.RTFlightsResponseDto
import com.khametov.rsttour.screens.main.domain.entity.FlightEntity
import com.khametov.rsttour.screens.main.domain.entity.RTFlightsEntity
import com.khametov.rsttour.screens.main.domain.repo.MainRepository
import javax.inject.Inject

internal class MainRepositoryImpl @Inject constructor(
    private val api: MainRestApi,
    private val localDataSource: FavoritesDataSource,
    private val flightsMapper: BaseMapper<RTFlightsResponseDto, RTFlightsEntity>,
    private val favoritesMapper: BaseMapper<FlightLocalDto, FlightEntity>,
    private val dtoMapper: BaseMapper<FlightEntity, FlightLocalDto>
): MainRepository {

    override suspend fun getFavorites(): List<FlightEntity> {
        return listOf()
    }
}