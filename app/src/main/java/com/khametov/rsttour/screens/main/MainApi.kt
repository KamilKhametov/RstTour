package com.khametov.rsttour.screens.main

import com.khametov.rsttour.common.base.BaseViewModel
import com.khametov.rsttour.screens.main.presentation.list.mvi.MainViewEvent
import com.khametov.rsttour.screens.main.presentation.list.mvi.MainViewState

interface MainApi {

    fun provideMainVM(): BaseViewModel<MainViewState, MainViewEvent>
//    fun provideMainDetailsVM(entity: FlightEntity): BaseViewModel<MainDetailsViewState, MainDetailsViewEvent>
}