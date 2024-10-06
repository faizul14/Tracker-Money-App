package com.faezolmp.tracker_money_app.core.domain.usecase

import com.faezolmp.tracker_money_app.core.data.Resource
import com.faezolmp.tracker_money_app.core.domain.model.ExampleModel
import com.faezolmp.tracker_money_app.core.domain.model.TramoModel
import com.faezolmp.tracker_money_app.core.domain.repository.Repository
import com.faezolmp.tracker_money_app.core.utils.StatusMoney
import kotlinx.coroutines.flow.Flow

class UseCaseIteractor(val repository: Repository) : UseCase {
    override fun exampleFunction(): Resource<ExampleModel> {
        return repository.invoke()
    }

    override fun getAllMoney(): Flow<Resource<List<TramoModel>>> {
        return repository.getAllMoney()
    }

    override fun getMoneyByStatus(status: StatusMoney): Flow<Resource<List<TramoModel>>> = when(status){
        StatusMoney.IN -> {
            repository.getMoneyByIn()
        }
        StatusMoney.OUT -> {
            repository.getMoneyByOut()
        }
    }
    override suspend fun insertMoney(data: TramoModel) {
        return repository.insertMoney(data)
    }
}