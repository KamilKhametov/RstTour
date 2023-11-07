package com.khametov.rsttour.screens.main.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BlogImageEntity(
    val sm: String,
    val md: String,
    val lg: String
): Parcelable