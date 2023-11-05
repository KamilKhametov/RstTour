package com.khametov.rsttour.screens.main.presentation.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.khametov.rsttour.R
import com.khametov.rsttour.common.base.BaseViewModel
import com.khametov.rsttour.screens.main.presentation.details.views.FlightInfo
import com.khametov.rsttour.screens.main.presentation.details.views.Location
import com.khametov.rsttour.screens.main.domain.entity.FlightEntity
import com.khametov.rsttour.screens.main.presentation.details.mvi.MainDetailsViewEvent
import com.khametov.rsttour.screens.main.presentation.details.mvi.MainDetailsViewState
import com.khametov.rsttour.screens.main.presentation.details.views.PlaneInfo
import com.khametov.rsttour.ui.kit.Toolbar
import com.khametov.rsttour.ui.theme.AeroTheme

@Composable
fun FlightDetailsScreen(
    navController: NavController,
    viewModel: BaseViewModel<MainDetailsViewState, MainDetailsViewEvent>
) {

    val state by viewModel.viewState.collectAsState()
    val entity = state.entity ?: return

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AeroTheme.colors.primaryBackground),
        content = {

            Toolbar(
                title = stringResource(id = R.string.more_tab_title, entity.a),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = AeroTheme.colors.secondaryBackground),
                startButtonListener = { navController.popBackStack() },
                endDrawableRes = if (true) R.drawable.icv_tab_booking else R.drawable.icv_tab_booking,
                endButtonListener = {
                    viewModel.perform(viewEvent = MainDetailsViewEvent.UpdateFavoritesState)
                }
            )

            Box(
                modifier = Modifier.fillMaxSize(),
                content = {

                    Content(entity = entity)

                    Button(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(size = 12.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = AeroTheme.colors.secondaryButton),
                        modifier = Modifier
                            .padding(
                                bottom = AeroTheme.dimens.dp16,
                                start = AeroTheme.dimens.dp16,
                                end = AeroTheme.dimens.dp16
                            )
                            .fillMaxWidth()
                            .height(height = 52.dp)
                            .align(alignment = Alignment.BottomCenter),
                        content = {
                            Text(
                                text = stringResource(id = R.string.more_tab_title),
                                style = AeroTheme.typography.buttonMedRoboto,
                                color = AeroTheme.colors.primaryButton
                            )
                        }
                    )
                }
            )
        }
    )
}

@Composable
private fun Content(entity: FlightEntity) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(state = rememberScrollState()),
        content = {
            FlightInfo(flight = entity)
            PlaneInfo()
            Location()
        }
    )
}