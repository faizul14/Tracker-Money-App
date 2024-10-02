package com.faezolmp.tracker_money_app.core.domain.repository

import com.faezolmp.tracker_money_app.core.data.Resource
import com.faezolmp.tracker_money_app.core.domain.model.ExampleModel

interface Repository {
    fun invoke() : Resource<ExampleModel>
}