package com.khametov.rsttour.screens.main.domain.entity

import android.os.Parcelable
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.khametov.rsttour.R
import kotlinx.parcelize.Parcelize

@Parcelize
enum class FlightStatus(
    @StringRes val value: Int,
    @ColorRes val tint: Color,
    val code: String,
) : Parcelable {
    InFlight(
        value = R.string.main_tab_title,
        tint = Color(0xFF0057FF),
        code = "active"
    ),

    Canceled(
        value = R.string.main_tab_title,
        tint = Color(0xFFC7BF00),
        code = "cancelled"
    ),

    Scheduled(
        value = R.string.main_tab_title,
        tint = Color(0xFFFF7A00),
        code = "scheduled"
    ),

    Landed(
        value = R.string.main_tab_title,
        tint = Color(0xFFFF7A00),
        code = "landed"
    );

    companion object {
        fun getBy(code: String): FlightStatus {
            values().forEach {
                if (it.code == code) {
                    return it
                }
            }
            throw IllegalArgumentException("flight status with code $code not found")
        }
    }
}
