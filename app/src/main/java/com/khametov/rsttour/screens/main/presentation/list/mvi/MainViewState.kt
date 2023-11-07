package com.khametov.rsttour.screens.main.presentation.list.mvi

import androidx.compose.runtime.mutableStateListOf
import com.khametov.rsttour.common.base.BaseViewState
import com.khametov.rsttour.common.helpers.ItemUi
import com.khametov.rsttour.screens.main.domain.entity.BlogDataEntity
import com.khametov.rsttour.screens.main.domain.entity.BlogEntity

data class MainViewState(
    val isLoading: Boolean,
    val content: List<BlogDataEntity>
): BaseViewState {

    companion object {

        fun provideInitialViewState(): MainViewState {
            return MainViewState(
                isLoading = false,
                content = mutableStateListOf()
            )
        }
    }
}