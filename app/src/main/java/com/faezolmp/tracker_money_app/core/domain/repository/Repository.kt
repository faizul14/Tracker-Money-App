package com.faezolmp.tracker_money_app.core.domain.repository

import com.faezolmp.tracker_money_app.core.data.Resource
import com.faezolmp.tracker_money_app.core.data.resource.local.entity.TramoEntity
import com.faezolmp.tracker_money_app.core.domain.model.ExampleModel
import com.faezolmp.tracker_money_app.core.domain.model.TramoModel
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun invoke() : Resource<ExampleModel>
    fun getAllMoney(): Flow<Resource<List<TramoModel>>>
    fun getMoneyByIn(): Flow<Resource<List<TramoModel>>>
    fun getMoneyByOut(): Flow<Resource<List<TramoModel>>>
    suspend fun insertMoney(data: TramoModel)
    fun updateMoney(data: TramoModel)
    suspend fun deleteMoney(data: TramoModel)
}