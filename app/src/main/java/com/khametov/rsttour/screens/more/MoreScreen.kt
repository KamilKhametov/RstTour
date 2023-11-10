package com.khametov.rsttour.screens.more

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.khametov.rsttour.ui.theme.RstTheme

@Composable
fun MoreScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = RstTheme.colors.primaryBackground),
        content = {}
    )
}