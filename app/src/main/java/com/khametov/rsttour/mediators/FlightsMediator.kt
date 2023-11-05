package com.khametov.rsttour.mediators

import androidx.annotation.MainThread
import com.khametov.rsttour.di.ModuleDependencyProvider
import com.khametov.rsttour.screens.main.MainApi
import com.khametov.rsttour.screens.main.FlightsDependencies
import com.khametov.rsttour.screens.main.FlightsFeature
import com.khametov.rsttour.screens.main.data.network.api.MainRestApi

class FlightsMediator {

    init {
        FlightsFeature.dependencies = ModuleDependencyProvider { createDependencies() }
    }

    @MainThread
    fun getApi(): MainApi = FlightsFeature.getApi()

    private fun createDependencies(): FlightsDependencies {
        return object : FlightsDependencies {
            override fun provideRestApi(): MainRestApi {
                return MediatorManager.networkMediator
                    .getApi()
                    .provideApiClass(
                        MainRestApi::class.java
                    )
            }
        }
    }
}