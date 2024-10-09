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
}