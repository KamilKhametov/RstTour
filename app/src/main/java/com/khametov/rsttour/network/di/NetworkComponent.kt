package com.khametov.rsttour.network.di

import com.khametov.rsttour.di.scopes.NetworkScope
import com.khametov.rsttour.network.NetworkApi
import com.khametov.rsttour.network.NetworkApiImpl
import dagger.Component

@NetworkScope
@Component(modules = [NetworkModule::class])
internal interface NetworkComponent {
    @Component.Factory
    interface Factory {

        fun create(): NetworkComponent
    }

    fun inject(apiImpl: NetworkApiImpl)

    fun moduleApi(): NetworkApi
}