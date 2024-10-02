package com.faezolmp.tracker_money_app.core.data

import com.faezolmp.tracker_money_app.core.domain.model.ExampleModel
import com.faezolmp.tracker_money_app.core.domain.repository.Repository
import com.faezolmp.tracker_money_app.core.utils.DataMapper

class ImplRepository : Repository {
    override fun invoke(): Resource<ExampleModel> {
        return Resource.Success(DataMapper.mapperExampleModelFromLayerDataToLayerDomain("Example data"))
    }
}