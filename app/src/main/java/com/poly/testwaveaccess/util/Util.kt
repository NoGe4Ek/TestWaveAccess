package com.poly.testwaveaccess.util

import android.icu.text.SimpleDateFormat
import android.icu.util.TimeZone
import java.util.*


class Util {
    companion object {
        //2014-02-19T11:40:41 -03:00   ->   HH:mm dd.MM.yy
        fun formatDate(fromDate: String): String {
            val sdfF = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss XXX", Locale.ENGLISH)
            val sdfT = SimpleDateFormat("HH:mm dd.MM.yy", Locale.ENGLISH)

            sdfF.timeZone = TimeZone.getTimeZone("UTC") // https://stackoverflow.com/a/44132186/18262206
            sdfT.timeZone = TimeZone.getTimeZone("UTC")

            val date = sdfF.parse(fromDate)

            return sdfT.format(date)
        }
    }
}