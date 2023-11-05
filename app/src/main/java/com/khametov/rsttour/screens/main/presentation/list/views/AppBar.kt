package com.khametov.rsttour.screens.main.presentation.list.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.khametov.rsttour.R
import com.khametov.rsttour.ui.theme.AeroTheme

@Composable
internal fun AppBar() {

    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 56.dp),
        backgroundColor = AeroTheme.colors.secondaryBackground,
        contentPadding = PaddingValues(horizontal = AeroTheme.dimens.dp16,
            vertical = AeroTheme.dimens.dp12),
        content = {
            Text(
                text = stringResource(id = R.string.main_tab_title),
                style = AeroTheme.typography.headerMedRoboto,
                color = AeroTheme.colors.headerColor,
                modifier = Modifier
                    .weight(weight = 1f)
                    .align(alignment = Alignment.CenterVertically)
            )


            // TODO: Добавить иконку для смены темы (черная/белая)
            Image(
                painter = painterResource(id = R.drawable.icv_tab_booking),
                contentDescription = null,
                modifier = Modifier.align(alignment = Alignment.CenterVertically)
            )
        }
    )
}