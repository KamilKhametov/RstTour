package com.khametov.rsttour.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.khametov.rsttour.R

val familyRoboto = FontFamily(
    Font(resId = R.font.roboto_bold, weight = FontWeight.Bold),
    Font(resId = R.font.roboto_medium, weight = FontWeight.Medium),
    Font(resId = R.font.roboto_regular, weight = FontWeight.Normal, style = FontStyle.Normal)
)

data class AeroTypography(
    val headerMedRoboto: TextStyle,
    val header2MedRoboto: TextStyle,
    val bodyMedRoboto: TextStyle,
    val subMedRoboto: TextStyle,
    val buttonMedRoboto: TextStyle,
)

val typography = AeroTypography(
    headerMedRoboto = TextStyle(
        fontSize = 20.sp,
        fontFamily = familyRoboto,
        fontWeight = FontWeight.Medium
    ),
    header2MedRoboto = TextStyle(
        fontSize = 16.sp,
        fontFamily = familyRoboto,
        fontWeight = FontWeight.Medium
    ),
    bodyMedRoboto = TextStyle(
        fontSize = 14.sp,
        fontFamily = familyRoboto,
        fontWeight = FontWeight.Medium
    ),
    subMedRoboto = TextStyle(
        fontSize = 12.sp,
        fontFamily = familyRoboto,
        fontWeight = FontWeight.Medium
    ),
    buttonMedRoboto = TextStyle(
        fontSize = 14.sp,
        fontFamily = familyRoboto,
        fontWeight = FontWeight.Medium
    )
)
