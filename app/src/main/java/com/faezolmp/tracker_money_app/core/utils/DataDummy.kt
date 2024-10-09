package com.faezolmp.tracker_money_app.core.utils

import com.faezolmp.tracker_money_app.core.data.Resource
import com.faezolmp.tracker_money_app.core.domain.model.TramoModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.Date

object DataDummy {

    fun dataDummy(): Flow<Resource<List<TramoModel>>> = flow {
        val listData = ArrayList<TramoModel>()

        for (i in 1..30) {
            val data = TramoModel(
                uid = 0,
                total = "100000${i}".toLong(),
                statusMoney = if (i % 2 == 0) "in" else "out",
                description = "Ket Pay/get Money",
                date = Date().toString() + Thread.currentThread().name
            )

            listData.add(data)

            emit(Resource.Success(listData))

            delay(1_000)
        }
    }

    fun dataDummy2(): List<TramoModel> {
        val listData = ArrayList<TramoModel>()
        for (i in 1..30){
            val data = TramoModel(
                uid = 0,
                total = "100000${i}".toLong(),
                statusMoney = if (i % 2 == 0) "in" else "out",
                description = if(i % 2 == 0) "WD Saham" else "Gorengan, Cilok, Martabak",
                date = Date().toString() + Thread.currentThread().name
            )
            listData.add(data)
        }
        return listData
    }


    fun dataDummyToDB(): Flow<TramoModel> = flow {
//        val listData = ArrayList<TramoModel>()

        for (i in 1..50) {
            val data = TramoModel(
                uid = 0,
                total = "100000${i}".toLong(),
                statusMoney = if (i % 2 == 0) "in" else "out",
                description = if(i % 2 == 0) "WD Saham" else "Gorengan, Cilok, Martabak",
                date = Date().toString() + Thread.currentThread().name
            )

//            listData.add(data)

            emit(data)

            delay(1_000)
        }
    }
}