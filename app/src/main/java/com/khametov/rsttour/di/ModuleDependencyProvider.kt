package com.khametov.rsttour.di

fun interface ModuleDependencyProvider<out T> {
    fun getDependencies(): T
}