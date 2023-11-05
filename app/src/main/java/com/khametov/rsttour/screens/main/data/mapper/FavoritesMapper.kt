package com.khametov.rsttour.screens.main.data.mapper

import com.khametov.rsttour.common.base.BaseMapper
import com.khametov.rsttour.screens.main.data.db.dto.FlightLocalDto
import com.khametov.rsttour.screens.main.domain.entity.FlightEntity
import javax.inject.Inject

internal class FavoritesMapper @Inject constructor(): BaseMapper<FlightLocalDto, FlightEntity> {

    override fun map(from: FlightLocalDto): FlightEntity {

        return FlightEntity(
            a = ""
        )
    }
}