package com.khametov.rsttour.screens.main.presentation.list.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.khametov.rsttour.R
import com.khametov.rsttour.screens.main.domain.entity.SettingsBundle
import com.khametov.rsttour.ui.theme.RstTheme

@Composable
internal fun AppBar(
    settingsState: SettingsBundle,
    onSettingsChanged: (SettingsBundle) -> Unit
) {

    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 56.dp),
        backgroundColor = RstTheme.colors.secondaryBackground,
        contentPadding = PaddingValues(
            horizontal = RstTheme.dimens.dp16,
            vertical = RstTheme.dimens.dp12
        ),
        content = {
            Text(
                text = stringResource(id = R.string.main_tab_title),
                style = RstTheme.typography.headerMedRoboto,
                color = RstTheme.colors.headerColor,
                modifier = Modifier
                    .weight(weight = 1f)
                    .align(alignment = Alignment.CenterVertically)
            )

            Image(
                painter = painterResource(
                    id = if (settingsState.isDarkMode)
                        R.drawable.icv_dark_theme
                    else
                        R.drawable.icv_light_theme
                ),
                contentDescription = null,
                modifier = Modifier
                    .align(alignment = Alignment.CenterVertically)
                    .size(32.dp)
                    .clickable {
                        onSettingsChanged.invoke(
                            settingsState.copy(
                                isDarkMode = !settingsState.isDarkMode
                            )
                        )
                    }
            )
        }
    )
}