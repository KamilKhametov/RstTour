package com.khametov.rsttour.screens.splash

import androidx.annotation.MainThread
import com.khametov.rsttour.screens.splash.di.DaggerSplashComponent
import com.khametov.rsttour.screens.splash.di.SplashComponent

object SplashFeature {

    private var component: SplashComponent? = null

    @MainThread
    fun getApi(): SplashApi = getComponent().moduleApi()

    internal fun getComponent(): SplashComponent =
        component ?: run {

            component = DaggerSplashComponent.factory().create()

            requireNotNull(component)
        }

    internal fun destroyModuleGraph() {
        component = null
    }
}