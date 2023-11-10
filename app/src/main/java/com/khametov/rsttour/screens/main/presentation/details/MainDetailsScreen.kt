package com.khametov.rsttour.screens.main.presentation.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.khametov.rsttour.R
import com.khametov.rsttour.common.base.BaseViewModel
import com.khametov.rsttour.common.extensions.isNull
import com.khametov.rsttour.common.helpers.DateUtils
import com.khametov.rsttour.screens.main.presentation.details.mvi.MainDetailsViewEvent
import com.khametov.rsttour.screens.main.presentation.details.mvi.MainDetailsViewState
import com.khametov.rsttour.ui.theme.AeroTheme

@Composable
fun MainDetailsScreen(
    navController: NavController,
    viewModel: BaseViewModel<MainDetailsViewState, MainDetailsViewEvent>
) {

    val screenState by viewModel.viewState.collectAsState()

    if (screenState.detailsEntity.isNull()) return

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = rememberImagePainter(screenState.entity?.image?.lg),
                contentDescription = "Back",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(304.dp),
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = R.drawable.icv_back_round),
                contentDescription = "Another Icon",
                modifier = Modifier
                    .padding(start = 20.dp, top = 44.dp)
                    .size(48.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )
        }

        Text(
            text = DateUtils.getDateRequestFormat(screenState.detailsEntity?.date).orEmpty(),
            style = AeroTheme.typography.subMedRoboto,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)
        )
        Text(
            text = screenState.detailsEntity?.title.orEmpty(),
            fontSize = 24.sp,
            style = AeroTheme.typography.headerMedRoboto,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = screenState.detailsEntity?.content.orEmpty(),
            fontSize = 16.sp,
            style = AeroTheme.typography.subMedRoboto,
            modifier = Modifier.padding(top = 32.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
        )
    }
}