package com.faezolmp.tracker_money_app.core.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object FormatDate {
    /**
     * Formats a given Date object into a localized Indonesian date and time string.
     *
     * This function takes a Date object as input and formats it into a string
     * representation of the date and time in Indonesian locale. The output format
     * is "dd MMM yyyy • HH:mm:ss", where:
     * - dd: Day of the month, with leading zeros if necessary.
     * - MMM: Abbreviated month name in Indonesian.
     * - yyyy: Year with century.
     * - HH: Hour of the day in 24-hour format, with leading zeros if necessary.
     * - mm: Minute of the hour, with leading zeros if necessary.
     * - ss: Second of the minute, with leading zeros if necessary.
     *
     * In case of any formatting errors, the function returns the original string
     * representation of the Date object.
     *
     * @param Date The Date object to be formatted.
     * @return The formatted date and time string in Indonesian locale, or the
     *         original string representation of the Date object if formatting fails.
     */
    fun formatInputDate(Date: Date): String {
        val outputFormat =
            SimpleDateFormat("dd MMM yyyy • HH:mm:ss", Locale("id", "ID")) // Locale Indonesia
        try {
            return outputFormat.format(Date)
        } catch (e: Exception) {
            return Date.toString()
        }
    }
}