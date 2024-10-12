package com.faezolmp.tracker_money_app.core.utils

import com.faezolmp.tracker_money_app.core.data.resource.local.entity.TramoEntity
import com.faezolmp.tracker_money_app.core.domain.model.ExampleModel
import com.faezolmp.tracker_money_app.core.domain.model.TramoModel

object DataMapper {
    fun mapperExampleModelFromLayerDataToLayerDomain(data: String): ExampleModel {
        return ExampleModel(
            dataExample = data
        )
    }

    fun sortMapper(data: String) = ExampleModel(
        dataExample = data
    )

    fun mapperDataToDomain(input: List<TramoEntity>): List<TramoModel> {
        val listData = ArrayList<TramoModel>()
        input.map {
            val data = TramoModel(uid = 0, total = it.total, statusMoney = it.statusMoney,description = it.description, date = it.date)

            listData.add(data)
        }
        return listData.reversed()
    }

    fun mapperDomainToData(input: TramoModel): TramoEntity{
        return TramoEntity(uid = 0, total = input.total, statusMoney = input.statusMoney, description = input.description, date = input.date)
    }
}