package com.khametov.rsttour.screens.main.data.mapper

import com.khametov.rsttour.common.base.BaseMapper
import com.khametov.rsttour.screens.main.data.model.BlogImageDto
import com.khametov.rsttour.screens.main.domain.entity.BlogImageEntity
import javax.inject.Inject

class BlogImageMapper @Inject constructor(): BaseMapper<BlogImageDto, BlogImageEntity> {

    override fun map(from: BlogImageDto): BlogImageEntity {
        return BlogImageEntity(
            sm = from.sm,
            md = from.md,
            lg = from.lg
        )
    }
}