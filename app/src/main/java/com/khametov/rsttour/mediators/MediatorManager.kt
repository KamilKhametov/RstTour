package com.khametov.rsttour.mediators

object MediatorManager {
    val networkMediator: NetworkMediator by lazy { NetworkMediator() }
    val flightsMediator: FlightsMediator by lazy { FlightsMediator() }
}