package com.khametov.rsttour.screens.flow.domain

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.khametov.rsttour.R
import com.khametov.rsttour.navigation.Screens

enum class TabItem(
    val route: String,
    @DrawableRes val icon: Int,
    @StringRes val title: Int,
) {

    MAIN(
        route = Screens.Main.route,
        icon = R.drawable.icv_tab_main,
        title = R.string.main_tab_title
    ),
    MAP(
        route = Screens.Map.route,
        icon = R.drawable.icv_tab_map,
        title = R.string.map_tab_title
    ),
    BOOKING(
        route = Screens.Booking.route,
        icon = R.drawable.icv_tab_booking,
        title = R.string.booking_tab_title
    ),
    CHAT(
        route = Screens.Chat.route,
        icon = R.drawable.icv_tab_chat,
        title = R.string.chat_tab_title
    ),
    MORE(
        route = Screens.More.route,
        icon = R.drawable.icv_tab_more,
        title = R.string.more_tab_title
    );
}