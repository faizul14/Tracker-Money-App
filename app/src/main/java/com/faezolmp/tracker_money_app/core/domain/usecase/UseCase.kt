package com.faezolmp.tracker_money_app.core.domain.usecase

import com.faezolmp.tracker_money_app.core.data.Resource
import com.faezolmp.tracker_money_app.core.domain.model.ExampleModel

interface UseCase {
    fun exampleFunction() : Resource<ExampleModel>
}