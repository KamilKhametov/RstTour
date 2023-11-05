package com.khametov.rsttour

import com.khametov.rsttour.model.AppEvent
import com.khametov.rsttour.model.AppState
import com.khametov.rsttour.common.base.BaseViewModel
import javax.inject.Inject

class AppViewModel @Inject constructor() : BaseViewModel<AppState, AppEvent>(
    initialState = AppState()
) {
    override fun observe(event: AppEvent) = Unit
}