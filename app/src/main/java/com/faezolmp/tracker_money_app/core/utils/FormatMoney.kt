package com.faezolmp.tracker_money_app.core.utils

import java.text.NumberFormat
import java.util.Currency

object FormatMoney {
    fun formatCurrency(amount: Long?): String {
        return if (amount != null) {
            NumberFormat.getCurrencyInstance().apply {
                maximumFractionDigits = 0
                currency = Currency.getInstance("IDR")
            }.format(amount)
        } else {
            "N/A"
        }
    }

    fun formatMoeneybyGroup(amount: String): String {
        return try {
            // Menghapus karakter yang tidak dibutuhkan dari string input
            val cleanAmount = amount.replace(",", "").replace(".", "")

            // Mengonversi string ke angka (Long)
            val parsedAmount = cleanAmount.toLong()

            // Memformat angka ke dalam format uang (ribuan, jutaan, dsb.)
            val formatter = java.text.DecimalFormat("#,###")

            // Menambahkan prefix "IDR" dan mengembalikan string hasil format
            formatter.format(parsedAmount)
        } catch (e: NumberFormatException) {
            // Jika input tidak valid, kembalikan string aslinya
            amount
        }
    }

    fun formatClearMoney(amount: String): Long {
        return try {
            amount.replace(",", "").replace(".", "").toLong()
        } catch (e: NumberFormatException) {
            0L
        }
    }
}