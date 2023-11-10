package com.khametov.rsttour

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.khametov.rsttour.screens.main.domain.entity.SettingsBundle
import com.khametov.rsttour.ui.theme.RstTheme
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

            RstTheme(
                darkTheme = isDarkMode.value,
                content = {
                    Surface(
                        color = RstTheme.colors.primaryBackground,
                        content = {
                            MainGraph(
                                settingsState = SettingsBundle(isDarkMode = isDarkMode.value),
                                onSettingsChanged = { bundle ->
                                    isDarkMode.value = bundle.isDarkMode
                                }
                            )
                        }
                    )
                }
            )
        }
    }
}