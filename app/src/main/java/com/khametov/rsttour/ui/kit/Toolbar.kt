package com.khametov.rsttour.ui.kit

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.khametov.rsttour.ui.theme.AeroTheme

@Composable
fun Toolbar(
    title: String,
    modifier: Modifier = Modifier,
    @DrawableRes startDrawableRes: Int = com.google.android.material.R.drawable.material_ic_keyboard_arrow_left_black_24dp,
    @DrawableRes endDrawableRes: Int? = null,
    endButtonListener: (() -> Unit)? = null,
    startButtonListener: () -> Unit,
) {
    TopAppBar(
        modifier = modifier,
        backgroundColor = AeroTheme.colors.secondaryBackground,
        content = {
            IconButton(
                onClick = { startButtonListener.invoke() },
                content = {
                    Image(
                        painter = painterResource(id = startDrawableRes),
                        contentDescription = null
                    )
                }
            )

            Text(
                text = title,
                style = AeroTheme.typography.headerMedRoboto,
                color = AeroTheme.colors.headerColor,
                modifier = Modifier
                    .weight(weight = 1f)
                    .padding(start = AeroTheme.dimens.dp16)
                    .align(alignment = Alignment.CenterVertically)
            )

            if (endDrawableRes != null) {
                IconButton(
                    onClick = { endButtonListener?.invoke() },
                    content = {
                        Image(
                            painter = painterResource(id = endDrawableRes),
                            contentDescription = null
                        )
                    }
                )
            }
        }
    )
}