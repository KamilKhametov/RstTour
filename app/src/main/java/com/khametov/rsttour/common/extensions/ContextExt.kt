package com.khametov.rsttour.common.extensions

import android.content.Context
import com.khametov.rsttour.common.base.BaseApplication
import com.khametov.rsttour.common.di.BaseComponent

val Context.baseComponent: BaseComponent
    get() = when (this) {
        is BaseApplication -> baseComponent
        else               -> applicationContext.baseComponent
    }