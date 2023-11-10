package com.khametov.rsttour.screens.main

import com.khametov.rsttour.common.base.BaseViewModel
import com.khametov.rsttour.screens.main.domain.entity.BlogDataEntity
import com.khametov.rsttour.screens.main.presentation.details.mvi.MainDetailsViewEvent
import com.khametov.rsttour.screens.main.presentation.details.mvi.MainDetailsViewModel
import com.khametov.rsttour.screens.main.presentation.details.mvi.MainDetailsViewState
import com.khametov.rsttour.screens.main.presentation.list.MainViewModel
import com.khametov.rsttour.screens.main.presentation.list.mvi.MainViewEvent
import com.khametov.rsttour.screens.main.presentation.list.mvi.MainViewState
import javax.inject.Inject
import javax.inject.Provider

class MainApiImpl @Inject constructor() : MainApi {

    @Inject lateinit var viewModelFactoryMain: Provider<MainViewModel>
    @Inject lateinit var mainDetailFactory: MainDetailsViewModel.Factory

    override fun provideMainVM(): BaseViewModel<MainViewState, MainViewEvent> {
        return viewModelFactoryMain.get()
    }

    override fun provideMainDetailsVM(entity: BlogDataEntity): BaseViewModel<MainDetailsViewState, MainDetailsViewEvent> {
        return mainDetailFactory.create(entity = entity)
    }
}