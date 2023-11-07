package com.khametov.rsttour.screens.main.data.mapper

import com.khametov.rsttour.common.base.BaseMapper
import com.khametov.rsttour.screens.main.data.db.model.BlogDataDto
import com.khametov.rsttour.screens.main.data.db.model.BlogDto
import com.khametov.rsttour.screens.main.domain.entity.BlogDataEntity
import com.khametov.rsttour.screens.main.domain.entity.BlogEntity
import javax.inject.Inject

class BlogMapper @Inject constructor(
    private val blogDataMapper: BaseMapper<BlogDataDto, BlogDataEntity>
): BaseMapper<BlogDto, BlogEntity> {

    override fun map(from: BlogDto): BlogEntity {
        return BlogEntity(
            data = from.data.map { blogDataDto ->
                blogDataMapper.map(blogDataDto)
            }
        )
    }
}