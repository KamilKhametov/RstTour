package com.khametov.rsttour.network.di

import com.khametov.rsttour.BuildConfig
import com.khametov.rsttour.di.scopes.NetworkScope
import com.khametov.rsttour.network.NetworkApi
import com.khametov.rsttour.network.NetworkApiImpl
import com.khametov.rsttour.network.interceptor.CredentialsInterceptor
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

@Module
internal abstract class NetworkModule {

    @Binds
    @NetworkScope
    abstract fun bindModuleApi(impl: NetworkApiImpl): NetworkApi

    companion object {

        @Provides
        @Reusable
        fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return interceptor
        }

        @Provides
        @Reusable
        fun provideOkHttp3(
            loggingInterceptor: HttpLoggingInterceptor,
            credentialsInterceptor: CredentialsInterceptor,
        ): OkHttpClient = OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) {
                addInterceptor(loggingInterceptor)
            }
            addInterceptor(credentialsInterceptor)
        }.build()


        @Provides
        @Reusable
        fun provideJson(): Json {
            return Json(Json.Default) {
                isLenient = true
                ignoreUnknownKeys = true
            }
        }
    }
}