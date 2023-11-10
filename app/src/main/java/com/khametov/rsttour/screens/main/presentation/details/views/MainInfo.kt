package com.khametov.rsttour.screens.main.presentation.details.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainScope
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintLayoutScope
import com.khametov.rsttour.R
import com.khametov.rsttour.screens.main.domain.entity.BlogDataEntity
import com.khametov.rsttour.ui.helpers.DashedLine
import com.khametov.rsttour.ui.theme.AeroTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun FlightInfo(flight: BlogDataEntity) {

    Card(
        onClick = {},
        enabled = false,
        shape = RoundedCornerShape(size = 20.dp),
        elevation = 4.dp,
        backgroundColor = AeroTheme.colors.secondaryBackground,
        modifier = Modifier
            .padding(
                start = AeroTheme.dimens.dp16,
                end = AeroTheme.dimens.dp16,
                top = AeroTheme.dimens.dp16
            )
            .fillMaxWidth(),
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = AeroTheme.dimens.dp16),
                content = {
                    MainInfo(flight = flight)

                    Divider(
                        modifier = Modifier
                            .padding(top = AeroTheme.dimens.dp16)
                            .fillMaxWidth(),
                        color = AeroTheme.colors.dividerColor
                    )

//                    StatusView(status = flight.title)

                    Divider(
                        modifier = Modifier
                            .padding(top = AeroTheme.dimens.dp16)
                            .fillMaxWidth(),
                        color = AeroTheme.colors.dividerColor
                    )

                    InfoElement(
                        title = stringResource(
                            id = R.string.main_tab_title
                        ),
                        value = "S7 Airlines"
                    )
                }
            )
        }
    )
}

@Composable
private fun MainInfo(flight: BlogDataEntity) {

    ConstraintLayout(
        modifier = Modifier.padding(horizontal = AeroTheme.dimens.dp16),
        content = {
            val (dateDep, dateArr) = createRefs()
            val (timeDep, timeArr, timeTotal, trajectory) = createRefs()
            val (depCity, depAirport, arrCity, arrAirport) = createRefs()

            Text(
                text = flight.title,
                style = AeroTheme.typography.subMedRoboto,
                color = AeroTheme.colors.secondaryText,
                modifier = Modifier.constrainAs(
                    ref = dateDep,
                    constrainBlock = {
                        start.linkTo(anchor = parent.start)
                        top.linkTo(anchor = parent.top)
                    }
                )
            )

            Text(
                text = flight.subtitle,
                style = AeroTheme.typography.subMedRoboto,
                color = AeroTheme.colors.secondaryText,
                modifier = Modifier.constrainAs(
                    ref = dateArr,
                    constrainBlock = {
                        end.linkTo(anchor = parent.end)
                        top.linkTo(anchor = parent.top)
                    }
                )
            )

            Text(
                text = flight.title,
                style = AeroTheme.typography.header2MedRoboto,
                color = AeroTheme.colors.primaryText,
                modifier = Modifier
                    .padding(top = AeroTheme.dimens.dp12)
                    .constrainAs(
                        ref = timeDep,
                        constrainBlock = {
                            start.linkTo(anchor = parent.start)
                            top.linkTo(anchor = dateDep.bottom)
                        }
                    )
            )

            Text(
                text = flight.subtitle,
                style = AeroTheme.typography.subMedRoboto,
                color = AeroTheme.colors.secondaryText,
                modifier = Modifier
                    .padding(bottom = AeroTheme.dimens.dp4)
                    .constrainAs(
                        ref = timeTotal,
                        constrainBlock = {
                            bottom.linkTo(anchor = timeDep.bottom)
                            start.linkTo(anchor = timeDep.end)
                            end.linkTo(anchor = timeArr.start)
                        }
                    )
            )

            Text(
                text = flight.title,
                style = AeroTheme.typography.header2MedRoboto,
                color = AeroTheme.colors.primaryText,
                modifier = Modifier
                    .padding(top = AeroTheme.dimens.dp12)
                    .constrainAs(
                        ref = timeArr,
                        constrainBlock = {
                            end.linkTo(anchor = parent.end)
                            top.linkTo(anchor = dateArr.bottom)
                        }
                    )
            )

            TrajectoryView(
                ref = trajectory,
                constrainBlock = {
                    start.linkTo(anchor = parent.start)
                    end.linkTo(anchor = parent.end)
                    top.linkTo(anchor = timeDep.bottom)
                }
            )

            Text(
                text = flight.subtitle,
                style = AeroTheme.typography.bodyMedRoboto,
                color = AeroTheme.colors.primaryText,
                modifier = Modifier.constrainAs(
                    ref = depCity,
                    constrainBlock = {
                        start.linkTo(anchor = parent.start)
                        top.linkTo(anchor = trajectory.bottom)
                    }
                )
            )

            Text(
                text = flight.title,
                style = AeroTheme.typography.subMedRoboto,
                color = AeroTheme.colors.secondaryText,
                modifier = Modifier
                    .padding(top = AeroTheme.dimens.dp8)
                    .constrainAs(
                        ref = depAirport,
                        constrainBlock = {
                            start.linkTo(anchor = parent.start)
                            top.linkTo(anchor = depCity.bottom)
                        }
                    )
            )

            Text(
                text = flight.subtitle,
                style = AeroTheme.typography.bodyMedRoboto,
                color = AeroTheme.colors.primaryText,
                modifier = Modifier.constrainAs(
                    ref = arrCity,
                    constrainBlock = {
                        end.linkTo(anchor = parent.end)
                        top.linkTo(anchor = trajectory.bottom)
                    }
                )
            )

            Text(
                text = flight.title,
                style = AeroTheme.typography.subMedRoboto,
                color = AeroTheme.colors.secondaryText,
                modifier = Modifier
                    .padding(top = AeroTheme.dimens.dp8)
                    .constrainAs(
                        ref = arrAirport,
                        constrainBlock = {
                            end.linkTo(anchor = parent.end)
                            top.linkTo(anchor = depCity.bottom)
                        }
                    )
            )

        }
    )
}

@Composable
private fun ConstraintLayoutScope.TrajectoryView(
    ref: ConstrainedLayoutReference,
    constrainBlock: ConstrainScope.() -> Unit,
) {

    ConstraintLayout(
        modifier = Modifier
            .padding(top = AeroTheme.dimens.dp16)
            .fillMaxWidth()
            .constrainAs(
                ref = ref,
                constrainBlock = constrainBlock
            ),
        content = {

            val (departure, dashedStart, plane, planeName, dashedEnd, arrival) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.icv_tab_main),
                contentDescription = null,
                modifier = Modifier.constrainAs(
                    ref = departure,
                    constrainBlock = {
                        start.linkTo(anchor = parent.start)
                        top.linkTo(anchor = parent.top)
                        bottom.linkTo(anchor = parent.bottom)
                    }
                )
            )

            DashedLine(
                color = Color(color = 0xFFAED6DC),
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.4f)
                    .height(height = 1.dp)
                    .constrainAs(
                        ref = dashedStart,
                        constrainBlock = {
                            start.linkTo(anchor = departure.end)
                            top.linkTo(anchor = parent.top)
                            end.linkTo(anchor = plane.start)
                            bottom.linkTo(anchor = parent.bottom)
                        }
                    )
            )

            Image(
                painter = painterResource(id = R.drawable.icv_tab_map),
                contentDescription = null,
                modifier = Modifier.constrainAs(
                    ref = plane,
                    constrainBlock = {
                        start.linkTo(anchor = dashedStart.end)
                        top.linkTo(anchor = parent.top)
                        end.linkTo(anchor = dashedEnd.start)
                        bottom.linkTo(anchor = parent.bottom)
                    }
                )
            )

            DashedLine(
                color = Color(color = 0xFFAED6DC),
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.4f)
                    .height(height = 1.dp)
                    .constrainAs(
                        ref = dashedEnd,
                        constrainBlock = {
                            start.linkTo(anchor = plane.end)
                            top.linkTo(anchor = parent.top)
                            end.linkTo(anchor = arrival.start)
                            bottom.linkTo(anchor = parent.bottom)
                        }
                    )
            )

            Text(
                text = "Boeing 737",
                style = AeroTheme.typography.subMedRoboto,
                color = Color(0xFFFF9A8D),
                modifier = Modifier
                    .padding(top = AeroTheme.dimens.dp8)
                    .constrainAs(
                        ref = planeName,
                        constrainBlock = {
                            start.linkTo(anchor = plane.start)
                            end.linkTo(anchor = plane.end)
                            top.linkTo(anchor = plane.bottom)
                        }
                    )
            )

            Image(
                painter = painterResource(id = R.drawable.icv_tab_booking),
                contentDescription = null,
                modifier = Modifier.constrainAs(
                    ref = arrival,
                    constrainBlock = {
                        top.linkTo(anchor = parent.top)
                        end.linkTo(anchor = parent.end)
                        bottom.linkTo(anchor = parent.bottom)
                    }
                )
            )

        }
    )
}
