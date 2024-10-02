package com.faezolmp.tracker_money_app.core.utils

import com.faezolmp.tracker_money_app.core.domain.model.ExampleModel

object DataMapper {
    fun mapperExampleModelFromLayerDataToLayerDomain(data: String): ExampleModel {
        return ExampleModel(
            dataExample = data
        )
    }

    fun sortMapper(data: String) = ExampleModel(
        dataExample = data
    )
}