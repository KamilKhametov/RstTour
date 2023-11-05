package com.khametov.rsttour.common.extensions

inline fun <T> uiLazy(crossinline operation: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE) {
    operation()
}
