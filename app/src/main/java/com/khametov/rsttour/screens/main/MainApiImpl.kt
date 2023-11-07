package com.khametov.rsttour.screens.main

import com.khametov.rsttour.common.base.BaseViewModel
import com.khametov.rsttour.screens.main.presentation.list.MainViewModel
import com.khametov.rsttour.screens.main.presentation.list.mvi.MainViewEvent
import com.khametov.rsttour.screens.main.presentation.list.mvi.MainViewState
import javax.inject.Inject
import javax.inject.Provider

class MainApiImpl @Inject constructor() : MainApi {

    @Inject lateinit var viewModelFactoryFlights: Provider<MainViewModel>
//    @Inject lateinit var flightDetailFactory: MainDetailsViewModel.Factory

    override fun provideMainVM(): BaseViewModel<MainViewState, MainViewEvent> {
        return viewModelFactoryFlights.get()
    }

//    override fun provideMainDetailsVM(entity: FlightEntity): BaseViewModel<MainDetailsViewState, MainDetailsViewEvent> {
//        return flightDetailFactory.create(entity = entity)
//    }
}