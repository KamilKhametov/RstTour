package com.khametov.rsttour.screens.splash.di

import com.khametov.rsttour.di.scopes.FeatureScope
import com.khametov.rsttour.screens.splash.SplashApi
import dagger.Component

@FeatureScope
@Component(modules = [SplashModule::class])
internal interface SplashComponent {

    @Component.Factory
    interface Factory {
        fun create(): SplashComponent
    }

    fun moduleApi(): SplashApi
}