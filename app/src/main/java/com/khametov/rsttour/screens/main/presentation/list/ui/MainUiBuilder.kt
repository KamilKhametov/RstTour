package com.khametov.rsttour.screens.main.presentation.list.ui

import com.khametov.rsttour.common.helpers.ItemUi
import com.khametov.rsttour.screens.main.domain.entity.FlightEntity
import com.khametov.rsttour.screens.main.domain.entity.PaginationEntity

interface MainUiBuilder {

    val items: List<ItemUi>
    val paginationState: PaginationEntity?
    val shouldPaginate: Boolean

    fun addFlights(flights: List<FlightEntity>)
    fun setPaginationData(entity: PaginationEntity)
}