package com.faezolmp.tracker_money_app.core.utils

import com.faezolmp.tracker_money_app.core.domain.model.TramoModel
import java.util.Date

object DataDummy {
    fun dataDummy2(): List<TramoModel> {
        val listData = ArrayList<TramoModel>()
        for (i in 1..30) {
            val data = TramoModel(
                uid = 0,
                total = "100000${i}".toLong(),
                statusMoney = if (i % 2 == 0) "in" else "out",
                description = if (i % 2 == 0) "WD Saham" else "Gorengan, Cilok, Martabak",
                date = Date().toString() + Thread.currentThread().name
            )
            listData.add(data)
        }
        return listData
    }
}