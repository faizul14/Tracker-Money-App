package com.faezolmp.tracker_money_app.presentation.screen.Home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faezolmp.tracker_money_app.core.data.Resource
import com.faezolmp.tracker_money_app.core.domain.model.TramoModel
import com.faezolmp.tracker_money_app.core.domain.usecase.UseCase
import com.faezolmp.tracker_money_app.core.utils.FormatDate
import com.faezolmp.tracker_money_app.core.utils.StatusMoney
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.util.Date
import java.util.Random

class HomeViewModel(val useCase: UseCase) : ViewModel() {
    private val _dataState = MutableStateFlow<Resource<List<TramoModel>>>(Resource.Loading())
    private val _dataStateForCount = MutableStateFlow<Resource<List<TramoModel>>>(Resource.Loading())
    private val _dataTransaction = MutableStateFlow<Int>(0)

    val dataState: StateFlow<Resource<List<TramoModel>>> = _dataState.asStateFlow()
    private val dataStateForCount: StateFlow<Resource<List<TramoModel>>> = _dataStateForCount.asStateFlow()

    val dataTransaction: StateFlow<Int> = _dataTransaction.asStateFlow()

    private val _moneyIn = MutableStateFlow<Long>(0)
    private val _moneyOut = MutableStateFlow<Long>(0)

    val moneyIn: StateFlow<Long>
        get() = _moneyIn
    val moneyOut: StateFlow<Long>
        get() = _moneyOut

    fun getDataByStatusMoney(status: StatusMoney) {
        viewModelScope.launch(Dispatchers.IO) {
            when (status) {
                StatusMoney.IN -> {
                    useCase.getMoneyByStatus(StatusMoney.IN).collect { data ->
                        _dataState.value = data
                    }
                }

                StatusMoney.OUT -> {
                    useCase.getMoneyByStatus(StatusMoney.OUT).collect { data ->
                        _dataState.value = data
                    }
                }
            }
        }
    }

    init {
        Log.d(
            "VIEWMODEL",
            "HIT VIEMODEL"
        )
        viewModelScope.launch {

//            DataDummy.dataDummy().collect{data ->
//                _dataState.value = data
//            }

//              insert aoutomation dummy data to local dababase

//            launch(Dispatchers.IO) {
//                DataDummy.dataDummyToDB().collect { data ->
//                    useCase.insertMoney(data)
//                }
//            }

            delay(3_000)

//              for see kita berada di thread mana
            Log.d(
                "VIEWMODEL",
                "Thread: ${Thread.currentThread().name}, DataTransaction: ${dataTransaction} & ${_dataTransaction.value}"
            )

//              for get all data money
//            useCase.getAllMoney().collect { data ->
//                _dataState.value = data
//            }

//            for get data money by status in
//            useCase.getMoneyByStatus(StatusMoney.IN).collect { data ->
//                _dataState.value = data
//            }
//            for get data money by status out
//            useCase.getMoneyByStatus(StatusMoney.OUT).collect{data ->
//                _dataState.value = data
//            }
            launch(Dispatchers.IO) {
                useCase.getAllMoney().collect { data ->
                    _dataState.value = data
                    _dataStateForCount.value = data
//                    _dataTransaction.value = dataState.count()
                }

            }

//            launch(Dispatchers.IO) {
//                dataState.filter { data ->
//                    data is Resource.Success
//                }.map { data ->
//                    data.data?.filter { dataFilter -> dataFilter.statusMoney == "in" }
//                }.map { data ->
//                    data?.map { it.total ?: 0L }?.reduceOrNull { acc, total -> acc + total } ?: 0L
//                }.collect { data ->
//                    _moneyIn.value = data
//                }
//            }
//
//            launch(Dispatchers.IO) {
//                useCase.getAllMoney().filter { data ->
//                    data is Resource.Success
//                }.map { data ->
//                    data.data?.filter { dataFilter -> dataFilter.statusMoney == "out" }
//                }.map { data ->
//                    data?.map { it.total ?: 0L }?.reduceOrNull { acc, total -> acc + total } ?: 0L
//                }.collect { data ->
//                    _moneyOut.value = data
//                }
//
//            }

            launch(Dispatchers.IO) {
                dataStateForCount
                    .filter { data -> data is Resource.Success }
                    .map { data -> (data as Resource.Success).data ?: emptyList() }
                    .map { data ->
                        val moneyIn = data.filter { it.statusMoney == "in" }
                            .map { it.total ?: 0L }
                            .reduceOrNull{acc, total -> acc + total} ?: 0L
                         val moneyOut = data.filter { it.statusMoney == "out" }
                            .map { it.total ?: 0L }
                            .reduceOrNull{acc, total -> acc + total} ?: 0L
                        val countTransaction = data.count() ?: 0

                        Triple(moneyIn, moneyOut, countTransaction)
                    }
                    .collect{(moneyIn, moneyOut, countTransaction) ->
                        _moneyIn.value = moneyIn
                        _moneyOut.value = moneyOut
                        _dataTransaction.value = countTransaction
                    }
            }
        }

    }

    fun insetDumyData() {

        viewModelScope.launch(Dispatchers.IO) {
            val i = Random().nextInt(10)
            val dataDumy = TramoModel(
                uid = 0,
                total = "100000${i}".toLong(),
                statusMoney = if (i % 2 == 0) "in" else "out",
                description = if (i % 2 == 0) "WD Saham" else "Gorengan, Cilok, Martabak",
                date = FormatDate.formatInputDate(Date())
            )
            useCase.insertMoney(dataDumy)
        }
    }

    fun FilterData(dataFilter: String){
        viewModelScope.launch(Dispatchers.IO) {
            useCase.getAllMoney().filter {
                it is Resource.Success
            }
                .map { data -> (data as Resource.Success).data ?: emptyList() }
                .map { data ->
                    if (dataFilter !== "all"){
                        data.filter { it.statusMoney == dataFilter }
                    }else {
                        data
                    }
                }
                .collect{data ->
                    _dataState.value = Resource.Success(data)
                }
        }
    }
}