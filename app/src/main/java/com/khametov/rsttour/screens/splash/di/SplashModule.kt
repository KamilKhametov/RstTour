package com.khametov.rsttour.screens.splash.di

import com.khametov.rsttour.di.scopes.FeatureScope
import com.khametov.rsttour.screens.splash.SplashApi
import com.khametov.rsttour.screens.splash.SplashApiImpl
import dagger.Binds
import dagger.Module

@Module
internal interface SplashModule {

    @Binds
    @FeatureScope
    fun bindModuleApi(impl: SplashApiImpl): SplashApi
}