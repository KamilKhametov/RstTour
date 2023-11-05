package com.khametov.rsttour.screens.main.di

import com.khametov.rsttour.common.base.BaseMapper
import com.khametov.rsttour.di.scopes.FeatureScope
import com.khametov.rsttour.screens.main.MainApi
import com.khametov.rsttour.screens.main.MainApiImpl
import com.khametov.rsttour.screens.main.data.db.FavoritesDataSource
import com.khametov.rsttour.screens.main.data.db.FavoritesDataSourceImpl
import com.khametov.rsttour.screens.main.data.db.dto.FlightLocalDto
import com.khametov.rsttour.screens.main.data.mapper.FavoritesMapper
import com.khametov.rsttour.screens.main.data.mapper.FavoritesToDtoMapper
import com.khametov.rsttour.screens.main.data.mapper.RTFlightsResponseMapper
import com.khametov.rsttour.screens.main.data.network.dto.RTFlightsResponseDto
import com.khametov.rsttour.screens.main.data.repo.MainRepositoryImpl
import com.khametov.rsttour.screens.main.domain.entity.FlightEntity
import com.khametov.rsttour.screens.main.domain.entity.RTFlightsEntity
import com.khametov.rsttour.screens.main.domain.repo.MainRepository
import com.khametov.rsttour.screens.main.presentation.list.ui.MainUiBuilder
import com.khametov.rsttour.screens.main.presentation.list.ui.MainUiBuilderImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
internal interface FlightsModule {

    @Binds
    @FeatureScope
    fun bindModuleApi(impl: MainApiImpl): MainApi

    @Binds
    @Reusable
    fun bindRepository(impl: MainRepositoryImpl): MainRepository

    @Binds
    @Reusable
    fun bindMapper(impl: RTFlightsResponseMapper): BaseMapper<RTFlightsResponseDto, RTFlightsEntity>

    @Binds
    @Reusable
    fun bindFavoritesDataSource(impl: FavoritesDataSourceImpl): FavoritesDataSource

    @Binds
    @Reusable
    fun bindFavoritesMapper(impl: FavoritesMapper): BaseMapper<FlightLocalDto, FlightEntity>

    @Binds
    @Reusable
    fun bindFavoritesToDtoMapper(impl: FavoritesToDtoMapper): BaseMapper<FlightEntity, FlightLocalDto>

    @Binds
    fun bindFlightsUiBuilder(impl: MainUiBuilderImpl): MainUiBuilder
}