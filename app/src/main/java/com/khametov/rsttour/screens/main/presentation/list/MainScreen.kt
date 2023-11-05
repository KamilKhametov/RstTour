package com.khametov.rsttour.screens.main.presentation.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.khametov.rsttour.common.base.BaseViewModel
import com.khametov.rsttour.common.extensions.navigate
import com.khametov.rsttour.navigation.Screens
import com.khametov.rsttour.screens.main.presentation.list.mvi.MainViewEvent
import com.khametov.rsttour.screens.main.presentation.list.mvi.MainViewState
import com.khametov.rsttour.screens.main.presentation.list.views.AppBar
import com.khametov.rsttour.screens.main.presentation.list.views.ContentView
import com.khametov.rsttour.screens.main.presentation.list.views.LoadingScreen
import com.khametov.rsttour.ui.theme.AeroTheme

@Composable
fun FlightsScreen(
    viewModel: BaseViewModel<MainViewState, MainViewEvent>,
    navController: NavController,
) {

    val screenState by viewModel.viewState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AeroTheme.colors.primaryBackground),
        content = {

            AppBar()

            if (screenState.isLoading) {
                LoadingScreen()
            }

            if (screenState.isLoading.not()) {
                ContentView(
                    content = screenState.content,
                    loadNextPage = {
                        viewModel.perform(viewEvent = MainViewEvent.LoadNextPage)
                    },
                    onFlightSelect = { entity ->
                        navController.currentBackStackEntry?.arguments?.putParcelable(
                            ARG_FLIGHT_ENTITY,
                            entity
                        )
                        navController.navigate(target = Screens.ItemDetails)
                    }
                )
            }
        }
    )
}

const val ARG_FLIGHT_ENTITY = "ARG_FLIGHT_ENTITY"