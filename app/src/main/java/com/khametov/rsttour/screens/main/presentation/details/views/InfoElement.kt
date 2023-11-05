package com.khametov.rsttour.screens.main.presentation.details.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.khametov.rsttour.ui.theme.AeroTheme

@Composable
internal fun InfoElement(title: String, value: String) {

    Text(
        text = title,
        style = AeroTheme.typography.subMedRoboto,
        color = AeroTheme.colors.secondaryText,
        modifier = Modifier.padding(
            top = AeroTheme.dimens.dp16,
            start = AeroTheme.dimens.dp16,
            end = AeroTheme.dimens.dp16
        )
    )

    Text(
        text = value,
        style = AeroTheme.typography.bodyMedRoboto,
        color = AeroTheme.colors.primaryText,
        modifier = Modifier.padding(
            top = AeroTheme.dimens.dp8,
            start = AeroTheme.dimens.dp16,
            end = AeroTheme.dimens.dp16,
        )
    )
}