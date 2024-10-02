package com.faezolmp.tracker_money_app.core.domain.usecase

import com.faezolmp.tracker_money_app.core.data.Resource
import com.faezolmp.tracker_money_app.core.domain.model.ExampleModel
import com.faezolmp.tracker_money_app.core.domain.repository.Repository

class UseCaseIteractor(val repository: Repository) : UseCase {
    override fun exampleFunction(): Resource<ExampleModel> {
        return repository.invoke()
    }
}