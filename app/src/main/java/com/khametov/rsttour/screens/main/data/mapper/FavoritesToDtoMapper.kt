package com.khametov.rsttour.screens.main.data.mapper

import com.khametov.rsttour.common.base.BaseMapper
import com.khametov.rsttour.screens.main.data.db.dto.FlightLocalDto
import com.khametov.rsttour.screens.main.domain.entity.FlightEntity
import javax.inject.Inject

internal class FavoritesToDtoMapper @Inject constructor():
    BaseMapper<FlightEntity, FlightLocalDto> {

    override fun map(from: FlightEntity): FlightLocalDto {

        return FlightLocalDto(
            a = ""
        )
    }
}