package com.faezolmp.tracker_money_app.core.data

import com.faezolmp.tracker_money_app.core.data.resource.local.LocalDataSource
import com.faezolmp.tracker_money_app.core.domain.model.ExampleModel
import com.faezolmp.tracker_money_app.core.domain.model.TramoModel
import com.faezolmp.tracker_money_app.core.domain.repository.Repository
import com.faezolmp.tracker_money_app.core.utils.DataMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ImplRepository(private val localDataSource: LocalDataSource) : Repository {
    val executor: ExecutorService = Executors.newSingleThreadExecutor()
    override fun invoke(): Resource<ExampleModel> {
        return Resource.Success(DataMapper.mapperExampleModelFromLayerDataToLayerDomain("Example data"))
    }

//    this use collect for reactive data stream, continue
    override fun getAllMoney(): Flow<Resource<List<TramoModel>>> = flow {
        try {
            emit(Resource.Loading())
            localDataSource.getAllMoney().collect { data ->
                emit(Resource.Success(DataMapper.mapperDataToDomain(data)))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

//    this use m operator map for (menerusakan data flow yang sudah ada)
    override fun getMoneyByIn(): Flow<Resource<List<TramoModel>>> = localDataSource.getMoneyByIn()
        .map { data ->
            Resource.Success(DataMapper.mapperDataToDomain(data))
        }

//    this usage first for take first data
    override fun getMoneyByOut(): Flow<Resource<List<TramoModel>>> = flow {
        try {
            emit(Resource.Loading())
            val data = localDataSource.getMoneyByOut().first()
            emit(Resource.Success(DataMapper.mapperDataToDomain(data)))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun insertMoney(data: TramoModel) {
        localDataSource.insertMoney(DataMapper.mapperDomainToData(data))
    }
}