package com.khametov.rsttour.mediators

import androidx.annotation.MainThread
import com.khametov.rsttour.screens.splash.SplashApi
import com.khametov.rsttour.screens.splash.SplashFeature

class SplashMediator {

    @MainThread
    fun getApi(): SplashApi = SplashFeature.getApi()
}