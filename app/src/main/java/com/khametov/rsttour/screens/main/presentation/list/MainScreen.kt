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
import com.khametov.rsttour.screens.main.domain.entity.SettingsBundle
import com.khametov.rsttour.screens.main.presentation.list.mvi.MainViewEvent
import com.khametov.rsttour.screens.main.presentation.list.mvi.MainViewState
import com.khametov.rsttour.screens.main.presentation.list.views.AppBar
import com.khametov.rsttour.screens.main.presentation.list.views.ContentView
import com.khametov.rsttour.screens.main.presentation.list.views.LoadingScreen
import com.khametov.rsttour.ui.theme.RstTheme

@Composable
fun MainScreen(
    viewModel: BaseViewModel<MainViewState, MainViewEvent>,
    navController: NavController,
    settingsState: SettingsBundle,
    onSettingsChanged: (SettingsBundle) -> Unit
) {

    val screenState by viewModel.viewState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = RstTheme.colors.primaryBackground),
        content = {

            AppBar(
                settingsState = settingsState,
                onSettingsChanged = onSettingsChanged
            )

            if (screenState.isLoading) {
                LoadingScreen()
            }

            if (screenState.isLoading.not()) {
                ContentView(
                    content = screenState.content,
                    onBlogSelect = { entity ->

                        navController.currentBackStackEntry?.arguments?.putParcelable(
                            ARG_MAIN_ENTITY,
                            entity
                        )

                        navController.navigate(target = Screens.FlightDetails)
                    }
                )
            }
        }
    )
}

const val ARG_MAIN_ENTITY = "ARG_MAIN_ENTITY"