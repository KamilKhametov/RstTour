package com.khametov.rsttour.screens.main.presentation.details.mvi

import com.khametov.rsttour.common.base.BaseViewModel
import com.khametov.rsttour.screens.main.domain.entity.BlogDataEntity
import com.khametov.rsttour.screens.main.domain.repo.MainRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class MainDetailsViewModel @AssistedInject constructor(
    @Assisted private val entity: BlogDataEntity,
    private val repository: MainRepository
) : BaseViewModel<MainDetailsViewState, MainDetailsViewEvent>(
    initialState = MainDetailsViewState.provideInitialState(entity = entity)
) {
    override fun observe(event: MainDetailsViewEvent) {

    }

    init {
        getDetailsData()
    }

    private fun getDetailsData() {

        launchIOCoroutine {

            val mainDetailsEntity = repository.getMainDetails(entity.id).data

            updateStateFromIo {
                copy(
                    detailsEntity = mainDetailsEntity
                )
            }
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(entity: BlogDataEntity): MainDetailsViewModel
    }
}