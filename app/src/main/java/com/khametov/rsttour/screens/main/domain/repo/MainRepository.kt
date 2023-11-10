package com.khametov.rsttour.screens.main.domain.repo

import com.khametov.rsttour.screens.main.domain.entity.BlogEntity
import com.khametov.rsttour.screens.main.domain.entity.MainDetailsEntity
import com.khametov.rsttour.screens.main.domain.entity.MainEntity

interface MainRepository {
    suspend fun getMain(): MainEntity
    suspend fun getBlog(requestUrl: String): BlogEntity
    suspend fun getMainDetails(blogId: Int): MainDetailsEntity
}