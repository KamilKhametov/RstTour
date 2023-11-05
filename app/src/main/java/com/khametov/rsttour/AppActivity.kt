package com.khametov.rsttour

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.khametov.rsttour.ui.theme.AeroTheme
import com.khametov.rsttour.ui.theme.FlightAeroTheme
import javax.inject.Inject

class AppActivity : ComponentActivity() {

    @Inject lateinit var viewModel: AppViewModel

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        AppDelegate.app.appComponent.inject(app = this)
        super.onCreate(savedInstanceState)

        setContent {

            val isDarkModeInitial = isSystemInDarkTheme()

            val isDarkMode = remember { mutableStateOf(isDarkModeInitial) }

            FlightAeroTheme(
                darkTheme = isDarkMode.value,
                content = {
                    Surface(
                        color = AeroTheme.colors.primaryBackground,
                        content = {
                            MainGraph()
                        }
                    )
                }
            )
        }
    }
}