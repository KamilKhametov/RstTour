package com.khametov.rsttour

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.khametov.rsttour.mediators.MediatorManager
import com.khametov.rsttour.common.extensions.aeroComposable
import com.khametov.rsttour.common.extensions.composeViewModel
import com.khametov.rsttour.screens.main.presentation.list.FlightsScreen
import com.khametov.rsttour.navigation.Screens
import com.khametov.rsttour.screens.flow.presentation.FlowScreen

@ExperimentalAnimationApi
@Composable
fun MainGraph(
//    settingsState: SettingsBundle,
//    onSettingsChanged: (SettingsBundle) -> Unit,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.Flow.route,
        builder = {

//            aeroComposable(
//                target = Screens.Settings,
//                content = {
//                    SettingsScreen(
//                        navController = navController,
//                        settingsState = settingsState,
//                        onSettingsChanged = onSettingsChanged
//                    )
//                }
//            )

            aeroComposable(
                target = Screens.Flow,
                content = {
                    FlowScreen(
                        isDarkMode = false,
                        flowGraphBuilder = {
                            aeroComposable(
                                target = Screens.Main,
                                content = {

                                    val viewModel = composeViewModel {
                                        MediatorManager.flightsMediator.getApi().provideMainVM()
                                    }

                                    FlightsScreen(
                                        viewModel = viewModel,
                                        navController = navController
                                    )
                                }
                            )

                            // Добавить остальные классы из bottom navigation
//                            aeroComposable(
//                                target = Screens.Profile,
//                                content = { ProfileScreen(navController = navController) }
//                            )
                        }
                    )
                }
            )

            aeroComposable(
                target = Screens.Main,
                content = {

                    val viewModel = composeViewModel {
                        MediatorManager.flightsMediator.getApi().provideMainVM()
                    }

                    FlightsScreen(navController = navController, viewModel = viewModel)
                }
            )

//            aeroComposable(
//                target = Screens.FlightDetails,
//                content = {
//
//                    val entity = navController.previousBackStackEntry
//                        ?.arguments
//                        ?.getParcelable<FlightEntity>(ARG_FLIGHT_ENTITY)
//                        ?: return@aeroComposable
//
//                    val viewModel = composeViewModel {
//                        MediatorManager.flightsMediator.getApi().provideMainDetailsVM(
//                            entity = entity
//                        )
//                    }
//
//                    FlightDetailsScreen(
//                        viewModel = viewModel,
//                        navController = navController
//                    )
//                }
//            )
//
        }
    )
}