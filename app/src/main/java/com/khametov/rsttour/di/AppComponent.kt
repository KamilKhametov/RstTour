package com.khametov.rsttour.di

import com.khametov.rsttour.AppActivity
import com.khametov.rsttour.common.di.BaseComponent
import dagger.Component

@Component(modules = [AppModule::class], dependencies = [BaseComponent::class])
@AppScope
interface AppComponent : BaseComponent {

    @Component.Factory
    interface Factory {
        fun create(baseComponent: BaseComponent): AppComponent
    }

    fun inject(app: AppActivity)
}