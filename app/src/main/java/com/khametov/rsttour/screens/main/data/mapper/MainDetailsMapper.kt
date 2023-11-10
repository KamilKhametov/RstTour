package com.khametov.rsttour.screens.main.data.mapper

import com.khametov.rsttour.common.base.BaseMapper
import com.khametov.rsttour.screens.main.data.model.MainDetailsDataDto
import com.khametov.rsttour.screens.main.data.model.MainDetailsDto
import com.khametov.rsttour.screens.main.domain.entity.MainDetailsDataEntity
import com.khametov.rsttour.screens.main.domain.entity.MainDetailsEntity
import javax.inject.Inject

class MainDetailsMapper @Inject constructor(
    private val dataMapper: BaseMapper<MainDetailsDataDto, MainDetailsDataEntity>
): BaseMapper<MainDetailsDto, MainDetailsEntity> {

    override fun map(from: MainDetailsDto): MainDetailsEntity {
        return MainDetailsEntity(
            data = dataMapper.map(from.data)
        )
    }
}