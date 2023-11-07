package com.khametov.rsttour.screens.main.data.repo

import com.khametov.rsttour.common.base.BaseMapper
import com.khametov.rsttour.screens.main.data.db.model.BlogDto
import com.khametov.rsttour.screens.main.data.db.model.MainDto
import com.khametov.rsttour.screens.main.data.network.api.MainRestApi
import com.khametov.rsttour.screens.main.domain.entity.BlogEntity
import com.khametov.rsttour.screens.main.domain.entity.MainEntity
import com.khametov.rsttour.screens.main.domain.repo.MainRepository
import javax.inject.Inject

internal class MainRepositoryImpl @Inject constructor(
    private val api: MainRestApi,
    private val mainMapper: BaseMapper<MainDto, MainEntity>,
    private val blogMapper: BaseMapper<BlogDto, BlogEntity>
): MainRepository {

    override suspend fun getMain(): MainEntity {
        return mainMapper.map(api.getMain())
    }

    override suspend fun getBlog(requestUrl: String): BlogEntity {
        return blogMapper.map(api.getBlogInfo(requestUrl))
    }
}