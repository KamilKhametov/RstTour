package com.khametov.rsttour.mediators

import androidx.annotation.MainThread
import com.khametov.rsttour.network.NetworkApi
import com.khametov.rsttour.network.NetworkWrapper

class NetworkMediator {

    @MainThread
    fun getApi(): NetworkApi = NetworkWrapper.getApi()
}