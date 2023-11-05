package com.khametov.rsttour.screens.main.presentation.list

import com.khametov.rsttour.common.base.BaseViewModel
import com.khametov.rsttour.common.coroutines.CoroutinesDispatcherProvider
import com.khametov.rsttour.common.extensions.orZero
import com.khametov.rsttour.screens.main.FlightsFeature
import com.khametov.rsttour.screens.main.domain.repo.MainRepository
import com.khametov.rsttour.screens.main.presentation.list.mvi.MainViewEvent
import com.khametov.rsttour.screens.main.presentation.list.mvi.MainViewState
import com.khametov.rsttour.screens.main.presentation.list.ui.MainUiBuilder
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val uiBuilder: MainUiBuilder,
    private val repository: MainRepository,
    dispatcherProvider: CoroutinesDispatcherProvider,
) : BaseViewModel<MainViewState, MainViewEvent>(
    initialState = MainViewState.provideInitialViewState(),
    dispatcherProvider = dispatcherProvider
) {

    init {
        fetchFlights()
    }

    override fun observe(event: MainViewEvent) {
        when (event) {
            is MainViewEvent.LoadNextPage -> fetchFlights()
        }
    }

    private fun fetchFlights() {

        if (uiBuilder.shouldPaginate.not()) return

        if (uiBuilder.paginationState?.offset.orZero() == 0) {
            updateState {
                copy(isLoading = true)
            }
        }

        // TODO: Делать мой запрос
//        launchIOCoroutine {
//            delay(timeMillis = 2000)
//
//            val response = repository.getRealTimeFlights(
//                offset = uiBuilder.paginationState?.offset.orZero()
//            )
//
//            uiBuilder.setPaginationData(entity = response.pagination)
//            uiBuilder.addFlights(flights = response.flights)
//
//            updateStateFromIo {
//                copy(content = uiBuilder.items, isLoading = false)
//            }
//        }
    }

    override fun onCleared() {
        FlightsFeature.destroyModuleGraph()
        super.onCleared()
    }
}