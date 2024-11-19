package com.faezolmp.tracker_money_app.core.data.resource.local

import com.faezolmp.tracker_money_app.core.data.resource.local.entity.TramoEntity
import com.faezolmp.tracker_money_app.core.data.resource.local.room.TramoDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val tramoDao: TramoDao) {
    fun getAllMoney(): Flow<List<TramoEntity>> = tramoDao.getAllMoney()
    fun getMoneyByIn(): Flow<List<TramoEntity>> = tramoDao.getMoneyByIn()
    fun getMoneyByOut(): Flow<List<TramoEntity>> = tramoDao.getMoneyByOut()
    suspend fun insertMoney(data: TramoEntity) = tramoDao.insetMoney(data)
    fun updateMoney(data: TramoEntity) = tramoDao.updateMoney(data)
    suspend fun deleteMoney(data: TramoEntity) = tramoDao.deleteMoney(data)
}