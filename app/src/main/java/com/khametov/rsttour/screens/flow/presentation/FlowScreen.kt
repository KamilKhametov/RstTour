package com.khametov.rsttour.screens.flow.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.khametov.rsttour.navigation.Screens
import com.khametov.rsttour.screens.flow.domain.TabItem
import com.khametov.rsttour.ui.theme.AeroTheme
import com.khametov.rsttour.ui.theme.Blue_4A536B
import com.khametov.rsttour.ui.theme.White

@Composable
fun FlowScreen(
    flowGraphBuilder: NavGraphBuilder.() -> Unit,
    isDarkMode: Boolean,
) {
    val navController = rememberNavController()
    val navItems = arrayOf(TabItem.MAIN, TabItem.MAP, TabItem.BOOKING, TabItem.CHAT, TabItem.MORE)

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val systemUiController = rememberSystemUiController()

    SideEffect(
        effect = {
            systemUiController.setSystemBarsColor(
                color = if (isDarkMode) Blue_4A536B else White
            )
        }
    )

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = AeroTheme.colors.secondaryBackground,
                content = {
                    navItems.forEach { target ->
                        BottomNavigationItem(
                            selected = currentRoute == target.route,
                            selectedContentColor = AeroTheme.colors.tintPrimary,
                            unselectedContentColor = AeroTheme.colors.tintSecondary,
                            alwaysShowLabel = true,
                            onClick = {
                                navController.navigate(
                                    route = target.route, builder = {
                                        navController.graph.startDestinationRoute?.let { route ->
                                            popUpTo(
                                                route = route, popUpToBuilder = {
                                                    saveState = true
                                                }
                                            )
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                )
                            },
                            label = {
                                Text(text = stringResource(id = target.title))
                            },
                            icon = {
                                Image(
                                    painter = painterResource(id = target.icon),
                                    contentDescription = null
                                )
                            }
                        )
                    }
                }
            )
        },
        content = { padding ->

            NavHost(
                navController = navController,
                startDestination = Screens.Main.route,
                modifier = Modifier.padding(paddingValues = padding),
                builder = flowGraphBuilder
            )
        }
    )
}