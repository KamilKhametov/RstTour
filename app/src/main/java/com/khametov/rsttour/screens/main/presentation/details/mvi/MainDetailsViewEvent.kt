package com.khametov.rsttour.screens.main.presentation.details.mvi

import com.khametov.rsttour.common.base.BaseViewEvent

sealed class MainDetailsViewEvent: BaseViewEvent {
    object UpdateFavoritesState: MainDetailsViewEvent()
}