package com.khametov.rsttour.mediators

object MediatorManager {
    val networkMediator: NetworkMediator by lazy { NetworkMediator() }
    val splashMediator: SplashMediator by lazy { SplashMediator() }
    val mainMediator: MainMediator by lazy { MainMediator() }
}