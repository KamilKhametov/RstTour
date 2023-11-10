package com.khametov.rsttour.screens.main.presentation.details.mvi

import com.khametov.rsttour.common.base.BaseViewState
import com.khametov.rsttour.screens.main.domain.entity.BlogDataEntity
import com.khametov.rsttour.screens.main.domain.entity.MainDetailsDataEntity

data class MainDetailsViewState(
    val entity: BlogDataEntity?,
    val detailsEntity: MainDetailsDataEntity?
) : BaseViewState {
    companion object {
        fun provideInitialState(entity: BlogDataEntity): MainDetailsViewState {
            return MainDetailsViewState(
                entity = entity,
                detailsEntity = null
            )
        }
    }
}