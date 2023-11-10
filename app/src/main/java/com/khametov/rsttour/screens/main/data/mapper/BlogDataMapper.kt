package com.khametov.rsttour.screens.main.data.mapper

import com.khametov.rsttour.common.base.BaseMapper
import com.khametov.rsttour.screens.main.data.model.BlogDataDto
import com.khametov.rsttour.screens.main.data.model.BlogImageDto
import com.khametov.rsttour.screens.main.domain.entity.BlogDataEntity
import com.khametov.rsttour.screens.main.domain.entity.BlogImageEntity
import javax.inject.Inject

class BlogDataMapper @Inject constructor(
    private val blogImageMapper: BaseMapper<BlogImageDto, BlogImageEntity>
): BaseMapper<BlogDataDto, BlogDataEntity> {

    override fun map(from: BlogDataDto): BlogDataEntity {
        return BlogDataEntity(
            id = from.id,
            image = blogImageMapper.map(from.image),
            title = from.title,
            subtitle = from.subtitle
        )
    }
}