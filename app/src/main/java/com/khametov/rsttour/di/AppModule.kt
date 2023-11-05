package com.khametov.rsttour.di

import androidx.lifecycle.ViewModel
import com.khametov.rsttour.AppViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelModule::class])
interface AppModule {

    @Binds
    @IntoMap
    @ViewModelModule.ViewModelKey(AppViewModel::class)
    fun bindAppViewModel(viewModel: AppViewModel): ViewModel
}