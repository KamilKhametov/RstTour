package com.khametov.rsttour.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun RstTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) {
        DarkPalette
    } else {
        LightPalette
    }

    CompositionLocalProvider(
        LocalRstColors provides colors,
        LocalRstTypography provides typography,
        LocalRstDimens provides RstDimens(),
        content = content
    )
}