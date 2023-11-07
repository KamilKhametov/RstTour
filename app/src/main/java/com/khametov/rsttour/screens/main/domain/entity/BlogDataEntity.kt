package com.khametov.rsttour.screens.main.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BlogDataEntity(
    val id: Int,
    val image: BlogImageEntity,
    val title: String,
    val subtitle: String
): Parcelable