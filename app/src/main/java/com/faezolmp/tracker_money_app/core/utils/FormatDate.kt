package com.faezolmp.tracker_money_app.core.utils

import java.text.SimpleDateFormat
import java.util.Locale

object FormatDate {
    /**
     * Mengubah format string tanggal dari format input ke format output yang diinginkan.
     *
     * Fungsi ini menerima string tanggal dalam format
     * "EEE MMM dd HH:mm:ss 'GMT' yyyy" (contoh: "Thu Oct 10 17:08:44 GMT 2024")
     * dan mengembalikannya dalam format "dd MMM yyyy • HH:mm:ss" (contoh: "10 Okt 2024 • 17:08:44").
     *
     * @param date String tanggal dalam format yang ditentukan.
     * @return String yang diformat sesuai dengan format output yang diinginkan.
     *         Jika terjadi kesalahan dalam parsing, mengembalikan "Invalid date".
     */
    fun formatByFmpStyle(date: String): String {
        // Mengatur format input sesuai dengan format string yang diterima
        val inputFormat = SimpleDateFormat("EEE MMM dd HH:mm:ss 'GMT' yyyy", Locale.ENGLISH)
        // Mengatur format output
        val outputFormat = SimpleDateFormat("dd MMM yyyy • HH:mm:ss", Locale("id", "ID")) // Locale Indonesia

        return try {
            val parsedDate = inputFormat.parse(date)
            outputFormat.format(parsedDate)
        } catch (e: Exception) {
            "Invalid date"
        }
    }

}