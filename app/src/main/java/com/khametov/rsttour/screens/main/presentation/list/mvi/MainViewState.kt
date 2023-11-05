package com.khametov.rsttour.screens.main.presentation.list.mvi

import androidx.compose.runtime.mutableStateListOf
import com.khametov.rsttour.common.base.BaseViewState
import com.khametov.rsttour.common.helpers.ItemUi

data class MainViewState(
    val isLoading: Boolean,
    val content: List<ItemUi>,
    val error: String
): BaseViewState {

    companion object {

        fun provideInitialViewState(): MainViewState {
            return MainViewState(
                isLoading = false,
                content = mutableStateListOf(),
                error = ""
            )
        }
    }
}