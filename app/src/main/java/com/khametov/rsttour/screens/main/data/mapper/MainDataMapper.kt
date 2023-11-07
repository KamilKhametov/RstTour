package com.khametov.rsttour.screens.main.data.mapper

import com.khametov.rsttour.common.base.BaseMapper
import com.khametov.rsttour.screens.main.data.db.model.MainContentDto
import com.khametov.rsttour.screens.main.data.db.model.MainDataDto
import com.khametov.rsttour.screens.main.domain.entity.MainContentEntity
import com.khametov.rsttour.screens.main.domain.entity.MainDataEntity
import javax.inject.Inject

class MainDataMapper @Inject constructor(
    private val mainContentMapper: BaseMapper<MainContentDto, MainContentEntity>
): BaseMapper<MainDataDto, MainDataEntity>{

    override fun map(from: MainDataDto): MainDataEntity {
        return MainDataEntity(
            content = from.content.map { mainContentDto ->
                mainContentMapper.map(mainContentDto)
            }
        )
    }
}