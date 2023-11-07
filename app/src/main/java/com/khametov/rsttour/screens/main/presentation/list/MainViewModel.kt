package com.khametov.rsttour.screens.main.presentation.list

import com.khametov.rsttour.common.base.BaseViewModel
import com.khametov.rsttour.common.coroutines.CoroutinesDispatcherProvider
import com.khametov.rsttour.screens.main.MainFeature
import com.khametov.rsttour.screens.main.domain.repo.MainRepository
import com.khametov.rsttour.screens.main.presentation.list.mvi.MainViewEvent
import com.khametov.rsttour.screens.main.presentation.list.mvi.MainViewState
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: MainRepository,
    dispatcherProvider: CoroutinesDispatcherProvider,
) : BaseViewModel<MainViewState, MainViewEvent>(
    initialState = MainViewState.provideInitialViewState(),
    dispatcherProvider = dispatcherProvider
) {

    init {
        getMain()
    }

    override fun observe(event: MainViewEvent) {

    }

    private fun getMain() {

        updateState {
            copy(isLoading = true)
        }

        launchIOCoroutine {

            val blogUrl = repository.getMain().data.content.find { it.template.type == "blog" }

            val blogEntity = repository.getBlog(blogUrl?.url.orEmpty())

            updateStateFromIo {
                copy(
                    isLoading = false,
                    content = blogEntity.data
                )
            }
        }
    }

    override fun onCleared() {
        MainFeature.destroyModuleGraph()
        super.onCleared()
    }
}