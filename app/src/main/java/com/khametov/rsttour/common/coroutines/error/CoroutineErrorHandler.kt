package com.khametov.rsttour.common.coroutines.error

import android.util.Log
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineExceptionHandler

internal class CoroutineErrorHandler(
    private val exceptionListener: (() -> Unit)? = null,
) : AbstractCoroutineContextElement(CoroutineExceptionHandler), CoroutineExceptionHandler {

    override fun handleException(context: CoroutineContext, exception: Throwable) {
        Log.d("HELLO", "$exception")
//        val error = CoreErrorHandler.handleException(throwable = exception)
//        exceptionListener?.invoke(error)
    }
}