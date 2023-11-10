package com.khametov.rsttour.screens.main.data.mapper

import com.khametov.rsttour.common.base.BaseMapper
import com.khametov.rsttour.screens.main.data.model.MainDataDto
import com.khametov.rsttour.screens.main.data.model.MainDto
import com.khametov.rsttour.screens.main.domain.entity.MainDataEntity
import com.khametov.rsttour.screens.main.domain.entity.MainEntity
import javax.inject.Inject

class MainMapper @Inject constructor(
    private val mainDataMapper: BaseMapper<MainDataDto, MainDataEntity>
): BaseMapper<MainDto, MainEntity> {

    override fun map(from: MainDto): MainEntity {
        return MainEntity(
            data = mainDataMapper.map(from.data)
        )
    }
}