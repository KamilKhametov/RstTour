package com.khametov.rsttour.screens.main.presentation.list.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.khametov.rsttour.screens.main.domain.entity.BlogDataEntity

@Composable
internal fun ContentView(
    content: List<BlogDataEntity>,
    onFlightSelect: (BlogDataEntity) -> Unit,
) {

    LazyColumn(
        contentPadding = PaddingValues(vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(space = 12.dp),
        modifier = Modifier.fillMaxSize(),
        content = {

            itemsIndexed(items = content) { index, item ->

                MainItem(
                    model = item,
                    onFlightSelect = onFlightSelect
                )
            }
        }
    )
}