package com.khametov.rsttour.screens.main

import androidx.annotation.MainThread
import com.khametov.rsttour.di.ModuleDependencyProvider
import com.khametov.rsttour.screens.main.data.network.api.MainRestApi
import com.khametov.rsttour.screens.main.di.DaggerFlightsComponent
import com.khametov.rsttour.screens.main.di.FlightsComponent

object FlightsFeature {

    private var component: FlightsComponent? = null

    var dependencies: ModuleDependencyProvider<FlightsDependencies>? = null

    @MainThread
    fun getApi(): MainApi = getComponent().moduleApi()

    internal fun getComponent(): FlightsComponent =
        component ?: run {

            component = DaggerFlightsComponent.factory().create(
                flightsDependencies = requireNotNull(
                    dependencies?.getDependencies()
                )
            )

            requireNotNull(component)
        }

    internal fun destroyModuleGraph() {
        component = null
    }
}


interface FlightsDependencies {
    fun provideRestApi(): MainRestApi
}
