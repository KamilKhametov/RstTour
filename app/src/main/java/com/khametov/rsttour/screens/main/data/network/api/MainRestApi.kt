package com.khametov.rsttour.screens.main.data.network.api

import com.khametov.rsttour.screens.main.data.db.model.BlogDto
import com.khametov.rsttour.screens.main.data.db.model.MainDetailsDto
import com.khametov.rsttour.screens.main.data.db.model.MainDto
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface MainRestApi {

    @GET("https://rsttur.ru/api/base-app/main?id=117")
    suspend fun getMain(): MainDto

    @GET
    suspend fun getBlogInfo(
        @Url url: String
    ): BlogDto

    @GET("https://rsttur.ru/api/base-app/blog-info?id=117")
    suspend fun getMainDetails(
        @Query("blog_id") blogId: Int
    ): MainDetailsDto
}