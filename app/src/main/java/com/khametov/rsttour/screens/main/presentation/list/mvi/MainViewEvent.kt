package com.khametov.rsttour.screens.main.presentation.list.mvi

import com.khametov.rsttour.common.base.BaseViewEvent

sealed class MainViewEvent: BaseViewEvent {
    object LoadNextPage: MainViewEvent()
}