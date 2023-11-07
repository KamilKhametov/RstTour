package com.khametov.rsttour.screens.main.data.mapper

import com.khametov.rsttour.common.base.BaseMapper
import com.khametov.rsttour.screens.main.data.db.model.MainContentDto
import com.khametov.rsttour.screens.main.data.db.model.MainTemplateDto
import com.khametov.rsttour.screens.main.domain.entity.MainContentEntity
import com.khametov.rsttour.screens.main.domain.entity.MainTemplateEntity
import javax.inject.Inject

class MainContentMapper @Inject constructor(
    private val mainTemplateMapper: BaseMapper<MainTemplateDto, MainTemplateEntity>
): BaseMapper<MainContentDto, MainContentEntity>{

    override fun map(from: MainContentDto): MainContentEntity {
        return MainContentEntity(
            title = from.title,
            template = mainTemplateMapper.map(from.template),
            url = from.url
        )
    }
}