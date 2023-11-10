package com.khametov.rsttour.screens.main.di

import com.khametov.rsttour.common.base.BaseMapper
import com.khametov.rsttour.di.scopes.FeatureScope
import com.khametov.rsttour.screens.main.MainApi
import com.khametov.rsttour.screens.main.MainApiImpl
import com.khametov.rsttour.screens.main.data.model.BlogDataDto
import com.khametov.rsttour.screens.main.data.model.BlogDto
import com.khametov.rsttour.screens.main.data.model.BlogImageDto
import com.khametov.rsttour.screens.main.data.model.MainContentDto
import com.khametov.rsttour.screens.main.data.model.MainDataDto
import com.khametov.rsttour.screens.main.data.model.MainDetailsDataDto
import com.khametov.rsttour.screens.main.data.model.MainDetailsDto
import com.khametov.rsttour.screens.main.data.model.MainDto
import com.khametov.rsttour.screens.main.data.model.MainTemplateDto
import com.khametov.rsttour.screens.main.data.mapper.BlogDataMapper
import com.khametov.rsttour.screens.main.data.mapper.BlogImageMapper
import com.khametov.rsttour.screens.main.data.mapper.BlogMapper
import com.khametov.rsttour.screens.main.data.mapper.MainContentMapper
import com.khametov.rsttour.screens.main.data.mapper.MainDataMapper
import com.khametov.rsttour.screens.main.data.mapper.MainDetailsDataMapper
import com.khametov.rsttour.screens.main.data.mapper.MainDetailsMapper
import com.khametov.rsttour.screens.main.data.mapper.MainMapper
import com.khametov.rsttour.screens.main.data.mapper.MainTemplateMapper
import com.khametov.rsttour.screens.main.data.repo.MainRepositoryImpl
import com.khametov.rsttour.screens.main.domain.entity.BlogDataEntity
import com.khametov.rsttour.screens.main.domain.entity.BlogEntity
import com.khametov.rsttour.screens.main.domain.entity.BlogImageEntity
import com.khametov.rsttour.screens.main.domain.entity.MainContentEntity
import com.khametov.rsttour.screens.main.domain.entity.MainDataEntity
import com.khametov.rsttour.screens.main.domain.entity.MainDetailsDataEntity
import com.khametov.rsttour.screens.main.domain.entity.MainDetailsEntity
import com.khametov.rsttour.screens.main.domain.entity.MainEntity
import com.khametov.rsttour.screens.main.domain.entity.MainTemplateEntity
import com.khametov.rsttour.screens.main.domain.repo.MainRepository
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
internal interface MainModule {

    @Binds
    @FeatureScope
    fun bindModuleApi(impl: MainApiImpl): MainApi

    @Binds
    @Reusable
    fun bindRepository(impl: MainRepositoryImpl): MainRepository

    @Binds
    @Reusable
    fun bindMainMapper(impl: MainMapper): BaseMapper<MainDto, MainEntity>

    @Binds
    @Reusable
    fun bindMainDataMapper(impl: MainDataMapper): BaseMapper<MainDataDto, MainDataEntity>

    @Binds
    @Reusable
    fun bindContentMapper(impl: MainContentMapper): BaseMapper<MainContentDto, MainContentEntity>

    @Binds
    @Reusable
    fun bindMainTemplateMapper(impl: MainTemplateMapper): BaseMapper<MainTemplateDto, MainTemplateEntity>

    @Binds
    @Reusable
    fun bindBlogMapper(impl: BlogMapper): BaseMapper<BlogDto, BlogEntity>

    @Binds
    @Reusable
    fun bindBlogDataMapper(impl: BlogDataMapper): BaseMapper<BlogDataDto, BlogDataEntity>

    @Binds
    @Reusable
    fun bindBlogImageMapper(impl: BlogImageMapper): BaseMapper<BlogImageDto, BlogImageEntity>

    @Binds
    @Reusable
    fun bindMainDetailsMapper(impl: MainDetailsMapper): BaseMapper<MainDetailsDto, MainDetailsEntity>

    @Binds
    @Reusable
    fun bindMainDetailsDataMapper(impl: MainDetailsDataMapper): BaseMapper<MainDetailsDataDto, MainDetailsDataEntity>
}