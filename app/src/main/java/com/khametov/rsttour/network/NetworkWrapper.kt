package com.khametov.rsttour.network

import com.khametov.rsttour.network.di.DaggerNetworkComponent
import com.khametov.rsttour.network.di.NetworkComponent

object NetworkWrapper {

    private var component: NetworkComponent? = null

    fun getApi(): NetworkApi = getComponent().moduleApi()

    internal fun getComponent(): NetworkComponent =
        component ?: run {
            component = DaggerNetworkComponent.factory().create()

            requireNotNull(component)
        }
}