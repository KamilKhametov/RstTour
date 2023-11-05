package com.khametov.rsttour.screens.main.presentation.list.ui

import androidx.compose.runtime.mutableStateListOf
import com.khametov.rsttour.common.extensions.orZero
import com.khametov.rsttour.common.extensions.uiLazy
import com.khametov.rsttour.common.helpers.ItemUi
import com.khametov.rsttour.screens.main.domain.entity.FlightEntity
import com.khametov.rsttour.screens.main.domain.entity.PaginationEntity
import com.khametov.rsttour.screens.main.presentation.list.ui.FlightsListModel.Flight.Companion.map2AdapterItem
import javax.inject.Inject

internal class MainUiBuilderImpl @Inject constructor() : MainUiBuilder {

    override val items by uiLazy { mutableStateListOf<ItemUi>() }

    override var paginationState: PaginationEntity? = null

    override val shouldPaginate: Boolean
        get() = paginationState?.offset.orZero() % DEFAULT_PAGINATION_LIMIT == 0

    override fun addFlights(flights: List<FlightEntity>) {
        removeNextPageLoading()

        val mappedFlights = flights.map { it.map2AdapterItem() }
        items.addAll(mappedFlights)

        checkForPaginationState()
    }

    override fun setPaginationData(entity: PaginationEntity) {
        paginationState = entity
    }

    private fun checkForPaginationState() {

        if (shouldPaginate) {
            items.add(FlightsListModel.Loading)
        }
    }

    private fun removeNextPageLoading() {

        items.lastOrNull()?.let { item ->
            if (item is FlightsListModel.Loading) {
                items.removeLast()
            }
        }
    }

    private companion object {
        private const val DEFAULT_PAGINATION_LIMIT = 10
    }
}