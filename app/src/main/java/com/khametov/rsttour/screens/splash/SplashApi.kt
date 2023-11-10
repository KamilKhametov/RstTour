package com.khametov.rsttour.screens.splash

import com.khametov.rsttour.common.base.BaseViewModel
import com.khametov.rsttour.screens.splash.presentation.mvi.SplashViewEvent
import com.khametov.rsttour.screens.splash.presentation.mvi.SplashViewState

interface SplashApi {

    fun provideViewModel(): BaseViewModel<SplashViewState, SplashViewEvent>
}