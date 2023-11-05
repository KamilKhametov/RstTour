package com.khametov.rsttour.screens.main.di

import com.khametov.rsttour.di.scopes.FeatureScope
import com.khametov.rsttour.screens.main.MainApi
import com.khametov.rsttour.screens.main.FlightsDependencies
import dagger.Component

@Component(
    modules = [FlightsModule::class],
    dependencies = [FlightsDependencies::class]
)
@FeatureScope
internal interface FlightsComponent {

    @Component.Factory
    interface Factory {

        fun create(
            flightsDependencies: FlightsDependencies,
        ): FlightsComponent
    }

    fun moduleApi(): MainApi
}