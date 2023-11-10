package com.khametov.rsttour.common.helpers

import java.text.SimpleDateFormat

const val INPUT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssXXX"
const val OUTPUT_DATE_FORMAT = "dd.MM.yyyy"

class DateUtils {

    companion object {

        fun getDateRequestFormat(date: String?): String? {
            return DateUtils().getDateRequestFormat(date)
        }
    }

    private fun getDateRequestFormat(inputDate: String?): String? {
        val inputDateFormat = SimpleDateFormat(INPUT_DATE_FORMAT)
        val outputDateFormat = SimpleDateFormat(OUTPUT_DATE_FORMAT)

        val date = inputDateFormat.parse(inputDate)
        return outputDateFormat.format(date)
    }
}