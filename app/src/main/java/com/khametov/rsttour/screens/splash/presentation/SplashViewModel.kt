package com.khametov.rsttour.screens.splash.presentation

import com.khametov.rsttour.common.base.BaseViewModel
import com.khametov.rsttour.screens.splash.SplashFeature
import com.khametov.rsttour.screens.splash.presentation.mvi.SplashViewEvent
import com.khametov.rsttour.screens.splash.presentation.mvi.SplashViewState
import javax.inject.Inject

class SplashViewModel @Inject constructor() : BaseViewModel<SplashViewState, SplashViewEvent>(
    initialState = SplashViewState()
) {

    override fun observe(event: SplashViewEvent) = Unit

    override fun onCleared() {
        SplashFeature.destroyModuleGraph()
        super.onCleared()
    }
}