package com.khametov.rsttour.screens.main.data.mapper

import com.khametov.rsttour.common.base.BaseMapper
import com.khametov.rsttour.screens.main.data.model.MainTemplateDto
import com.khametov.rsttour.screens.main.domain.entity.MainTemplateEntity
import javax.inject.Inject

class MainTemplateMapper @Inject constructor(): BaseMapper<MainTemplateDto, MainTemplateEntity> {

    override fun map(from: MainTemplateDto): MainTemplateEntity {
        return MainTemplateEntity(
            type = from.type
        )
    }
}