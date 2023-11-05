package com.khametov.rsttour

import com.khametov.rsttour.common.base.BaseApplication
import com.khametov.rsttour.di.AppComponent
import com.khametov.rsttour.di.DaggerAppComponent

class AppDelegate : BaseApplication() {

    init {
        app = this
    }

    val appComponent by lazy {
        DaggerAppComponent.factory().create(baseComponent = baseComponent)
    }

    companion object {
        lateinit var app: AppDelegate
    }
}