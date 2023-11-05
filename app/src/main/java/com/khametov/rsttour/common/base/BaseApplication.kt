package com.khametov.rsttour.common.base

import android.app.Application
import com.khametov.rsttour.common.di.BaseComponent
import com.khametov.rsttour.common.di.DaggerBaseComponent

abstract class BaseApplication : Application() {

    init {
        app = this
    }

    val baseComponent by lazy {
        DaggerBaseComponent.factory().create(context = this)
    }

    companion object {
        lateinit var app: BaseApplication
    }
}