package com.khametov.rsttour

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.khametov.rsttour.mediators.MediatorManager
import com.khametov.rsttour.common.extensions.aeroComposable
import com.khametov.rsttour.common.extensions.composeViewModel
import com.khametov.rsttour.screens.main.presentation.list.MainScreen
import com.khametov.rsttour.navigation.Screens
import com.khametov.rsttour.screens.flow.presentation.FlowScreen
import com.khametov.rsttour.screens.main.domain.entity.BlogDataEntity
import com.khametov.rsttour.screens.main.presentation.details.MainDetailsScreen
import com.khametov.rsttour.screens.main.presentation.list.ARG_MAIN_ENTITY
import com.khametov.rsttour.screens.splash.presentation.SplashScreen

@ExperimentalAnimationApi
@Composable
fun MainGraph(
//    settingsState: SettingsBundle,
//    onSettingsChanged: (SettingsBundle) -> Unit,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route,
        builder = {

            aeroComposable(
                target = Screens.Splash,
                content = {

                    val viewModel = composeViewModel {
                        MediatorManager.splashMediator.getApi().provideViewModel()
                    }

                    SplashScreen(viewModel = viewModel, navController = navController)
                }
            )

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
                target = Screens.FlightDetails,
                content = {

                    val entity = navController.previousBackStackEntry
                        ?.arguments
                        ?.getParcelable<BlogDataEntity>(ARG_MAIN_ENTITY)
                        ?: return@aeroComposable

                    val viewModel = composeViewModel {
                        MediatorManager.mainMediator.getApi().provideMainDetailsVM(
                            entity = entity
                        )
                    }

                    MainDetailsScreen(
                        viewModel = viewModel,
                        navController = navController
                    )
                }
            )

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
                                        MediatorManager.mainMediator.getApi().provideMainVM()
                                    }

                                    MainScreen(
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
        }
    )
}