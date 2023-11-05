package com.khametov.rsttour.navigation

sealed class Screens : NavTarget {

    object Flow : Screens() {
        override val route: String = "flow"
    }

    object Main : Screens() {
        override val route: String = "main"
    }

    object Map : Screens() {
        override val route: String = "map"
    }

    object Booking : Screens() {
        override val route: String = "booking"
    }

    object Chat : Screens() {
        override val route: String = "chat"
    }

    object More : Screens() {
        override val route: String = "more"
    }

    object ItemDetails : Screens() {
        override val route: String = "item_details"
    }
}