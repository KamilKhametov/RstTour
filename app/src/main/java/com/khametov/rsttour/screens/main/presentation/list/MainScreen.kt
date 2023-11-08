package com.khametov.rsttour.screens.main.presentation.list

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
fun MainScreen(
    viewModel: BaseViewModel<MainViewState, MainViewEvent>,
    navController: NavController,
) {

    val screenState by viewModel.viewState.collectAsState()

    val context = LocalContext.current

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
                    onFlightSelect = { entity ->
                        Toast.makeText(context, "$entity", Toast.LENGTH_SHORT).show()

                        // TODO: Реализовать переход на деталку
//                        navController.currentBackStackEntry?.arguments?.putParcelable(
//                            ARG_MAIN_ENTITY,
//                            entity
//                        )
//                        navController.navigate(target = Screens.ItemDetails)
                    }
                )
            }
        }
    )
}

const val ARG_MAIN_ENTITY = "ARG_MAIN_ENTITY"