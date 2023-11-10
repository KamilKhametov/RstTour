package com.khametov.rsttour.screens.splash

import com.khametov.rsttour.common.base.BaseViewModel
import com.khametov.rsttour.screens.splash.presentation.mvi.SplashViewEvent
import com.khametov.rsttour.screens.splash.presentation.mvi.SplashViewState
import com.khametov.rsttour.screens.splash.presentation.SplashViewModel
import javax.inject.Inject
import javax.inject.Provider

class SplashApiImpl @Inject constructor() : SplashApi {

    @Inject lateinit var viewModelFactory: Provider<SplashViewModel>

    override fun provideViewModel(): BaseViewModel<SplashViewState, SplashViewEvent> {
        return viewModelFactory.get()
    }
}