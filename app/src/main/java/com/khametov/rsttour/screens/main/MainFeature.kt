package com.khametov.rsttour.screens.main

import androidx.annotation.MainThread
import com.khametov.rsttour.di.ModuleDependencyProvider
import com.khametov.rsttour.screens.main.data.network.api.MainRestApi
import com.khametov.rsttour.screens.main.di.DaggerMainComponent
import com.khametov.rsttour.screens.main.di.MainComponent

object MainFeature {

    private var component: MainComponent? = null

    var dependencies: ModuleDependencyProvider<MainDependencies>? = null

    @MainThread
    fun getApi(): MainApi = getComponent().moduleApi()

    internal fun getComponent(): MainComponent =
        component ?: run {

            component = DaggerMainComponent.factory().create(
                mainDependencies = requireNotNull(
                    dependencies?.getDependencies()
                )
            )

            requireNotNull(component)
        }

    internal fun destroyModuleGraph() {
        component = null
    }
}

interface MainDependencies {

    fun provideRestApi(): MainRestApi
}
