package com.khametov.rsttour.screens.main.presentation.details.mvi

import com.khametov.rsttour.common.base.BaseViewState
import com.khametov.rsttour.screens.main.domain.entity.FlightEntity

data class MainDetailsViewState(
    val entity: FlightEntity?
) : BaseViewState {
    companion object {
        fun provideInitialState(entity: FlightEntity): MainDetailsViewState {
            return MainDetailsViewState(
                entity = entity
            )
        }
    }
}