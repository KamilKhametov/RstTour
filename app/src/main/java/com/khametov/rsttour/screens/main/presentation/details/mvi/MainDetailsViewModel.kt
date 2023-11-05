package com.khametov.rsttour.screens.main.presentation.details.mvi

import com.khametov.rsttour.common.base.BaseViewModel
import com.khametov.rsttour.screens.main.domain.entity.FlightEntity
import com.khametov.rsttour.screens.main.domain.repo.MainRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class MainDetailsViewModel @AssistedInject constructor(
    @Assisted private val entity: FlightEntity,
    private val repository: MainRepository
) : BaseViewModel<MainDetailsViewState, MainDetailsViewEvent>(
    initialState = MainDetailsViewState.provideInitialState(entity = entity)
) {
    override fun observe(event: MainDetailsViewEvent) {
        when (event) {
            MainDetailsViewEvent.UpdateFavoritesState -> updateFavorites()
        }
    }

    private fun updateFavorites() {


    }

    @AssistedFactory
    interface Factory {
        fun create(entity: FlightEntity): MainDetailsViewModel
    }
}