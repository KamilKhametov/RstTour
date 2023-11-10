package com.khametov.rsttour

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.khametov.rsttour.mediators.MediatorManager
import com.khametov.rsttour.common.extensions.rstComposable
import com.khametov.rsttour.common.extensions.composeViewModel
import com.khametov.rsttour.screens.main.presentation.list.MainScreen
import com.khametov.rsttour.navigation.Screens
import com.khametov.rsttour.screens.booking.BookingScreen
import com.khametov.rsttour.screens.chat.ChatScreen
import com.khametov.rsttour.screens.flow.presentation.FlowScreen
import com.khametov.rsttour.screens.main.domain.entity.BlogDataEntity
import com.khametov.rsttour.screens.main.domain.entity.SettingsBundle
import com.khametov.rsttour.screens.main.presentation.details.MainDetailsScreen
import com.khametov.rsttour.screens.main.presentation.list.ARG_MAIN_ENTITY
import com.khametov.rsttour.screens.map.MapScreen
import com.khametov.rsttour.screens.more.MoreScreen
import com.khametov.rsttour.screens.splash.presentation.SplashScreen

@ExperimentalAnimationApi
@Composable
fun MainGraph(
    settingsState: SettingsBundle,
    onSettingsChanged: (SettingsBundle) -> Unit,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route,
        builder = {

            rstComposable(
                target = Screens.Splash,
                content = {

                    val viewModel = composeViewModel {
                        MediatorManager.splashMediator.getApi().provideViewModel()
                    }

                    SplashScreen(viewModel = viewModel, navController = navController)
                }
            )

            rstComposable(
                target = Screens.FlightDetails,
                content = {

                    val entity = navController.previousBackStackEntry
                        ?.arguments
                        ?.getParcelable<BlogDataEntity>(ARG_MAIN_ENTITY)
                        ?: return@rstComposable

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

            rstComposable(
                target = Screens.Flow,
                content = {
                    FlowScreen(
                        isDarkMode = settingsState.isDarkMode,
                        flowGraphBuilder = {
                            rstComposable(
                                target = Screens.Main,
                                content = {

                                    val viewModel = composeViewModel {
                                        MediatorManager.mainMediator.getApi().provideMainVM()
                                    }

                                    MainScreen(
                                        viewModel = viewModel,
                                        navController = navController,
                                        settingsState = settingsState,
                                        onSettingsChanged = onSettingsChanged
                                    )
                                }
                            )

                            rstComposable(
                                target = Screens.Map,
                                content = {
                                    MapScreen()
                                }
                            )

                            rstComposable(
                                target = Screens.Booking,
                                content = {
                                    BookingScreen()
                                }
                            )

                            rstComposable(
                                target = Screens.Chat,
                                content = {
                                    ChatScreen()
                                }
                            )

                            rstComposable(
                                target = Screens.More,
                                content = {
                                    MoreScreen()
                                }
                            )
                        }
                    )
                }
            )
        }
    )
}