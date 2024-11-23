package com.faezolmp.tracker_money_app.core.domain.usecase

import com.faezolmp.tracker_money_app.core.data.Resource
import com.faezolmp.tracker_money_app.core.domain.model.ExampleModel
import com.faezolmp.tracker_money_app.core.domain.model.TramoModel
import com.faezolmp.tracker_money_app.core.utils.StatusMoney
import kotlinx.coroutines.flow.Flow

interface UseCase {
    fun exampleFunction(): Resource<ExampleModel>
    fun getAllMoney(): Flow<Resource<List<TramoModel>>>
    fun getMoneyByStatus(status: StatusMoney): Flow<Resource<List<TramoModel>>>
    suspend fun insertMoney(data: TramoModel)
    fun updateMoney(data: TramoModel)
    suspend fun deleteMoney(data: TramoModel)
}