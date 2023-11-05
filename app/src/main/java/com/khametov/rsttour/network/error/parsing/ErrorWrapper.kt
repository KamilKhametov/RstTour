package com.nassdk.network.error.parsing

import com.khametov.rsttour.network.error.parsing.ErrorEntity

interface ErrorWrapper {
    fun getError(throwable: Throwable): ErrorEntity
}