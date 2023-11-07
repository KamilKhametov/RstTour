package com.khametov.rsttour.mediators

import androidx.annotation.MainThread
import com.khametov.rsttour.di.ModuleDependencyProvider
import com.khametov.rsttour.screens.main.MainApi
import com.khametov.rsttour.screens.main.MainDependencies
import com.khametov.rsttour.screens.main.MainFeature
import com.khametov.rsttour.screens.main.data.network.api.MainRestApi

class MainMediator {

    init {
        MainFeature.dependencies = ModuleDependencyProvider { createDependencies() }
    }

    @MainThread
    fun getApi(): MainApi = MainFeature.getApi()

    private fun createDependencies(): MainDependencies {
        return object : MainDependencies {
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