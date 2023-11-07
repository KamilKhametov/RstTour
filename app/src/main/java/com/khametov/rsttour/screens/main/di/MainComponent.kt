package com.khametov.rsttour.screens.main.di

import com.khametov.rsttour.di.scopes.FeatureScope
import com.khametov.rsttour.screens.main.MainApi
import com.khametov.rsttour.screens.main.MainDependencies
import dagger.Component

@Component(
    modules = [MainModule::class],
    dependencies = [MainDependencies::class]
)
@FeatureScope
internal interface MainComponent {

    @Component.Factory
    interface Factory {

        fun create(
            mainDependencies: MainDependencies,
        ): MainComponent
    }

    fun moduleApi(): MainApi
}