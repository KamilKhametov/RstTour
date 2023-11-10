package com.khametov.rsttour.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf

object RstTheme {
    val colors: RstColors
        @Composable
        get() = LocalRstColors.current

    val typography: RstTypography
        @Composable
        get() = LocalRstTypography.current

    val dimens: RstDimens
        @Composable
        get() = LocalRstDimens.current
}

val LocalRstColors = staticCompositionLocalOf<RstColors> {
    error("No colors provided")
}

val LocalRstTypography = staticCompositionLocalOf<RstTypography> {
    error("No typography provided")
}

val LocalRstDimens = staticCompositionLocalOf<RstDimens> {
    error("No dimens provided")
}