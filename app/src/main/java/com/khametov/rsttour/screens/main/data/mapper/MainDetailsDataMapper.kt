package com.khametov.rsttour.screens.main.data.mapper

import com.khametov.rsttour.common.base.BaseMapper
import com.khametov.rsttour.screens.main.data.db.model.MainDetailsDataDto
import com.khametov.rsttour.screens.main.domain.entity.MainDetailsDataEntity
import javax.inject.Inject

class MainDetailsDataMapper @Inject constructor():
    BaseMapper<MainDetailsDataDto, MainDetailsDataEntity> {

    override fun map(from: MainDetailsDataDto): MainDetailsDataEntity {
        return MainDetailsDataEntity(
            title = from.title,
            subtitle = from.subtitle,
            date = from.date,
            content = from.content
        )
    }
}