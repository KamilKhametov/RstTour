package com.khametov.rsttour.common.base

interface BaseMapper<FROM, TO> {
    fun map(from: FROM): TO
}
