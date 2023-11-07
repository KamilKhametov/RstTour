package com.khametov.rsttour.screens.main.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BlogEntity(
    val data: List<BlogDataEntity>
): Parcelable