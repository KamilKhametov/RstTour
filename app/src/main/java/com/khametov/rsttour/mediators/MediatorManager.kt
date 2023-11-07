package com.khametov.rsttour.mediators

object MediatorManager {
    val networkMediator: NetworkMediator by lazy { NetworkMediator() }
    val flightsMediator: MainMediator by lazy { MainMediator() }
}