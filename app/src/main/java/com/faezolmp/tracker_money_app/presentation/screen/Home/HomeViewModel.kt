package com.faezolmp.tracker_money_app.presentation.screen.Home

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faezolmp.tracker_money_app.core.data.Resource
import com.faezolmp.tracker_money_app.core.domain.model.ExampleModel
import com.faezolmp.tracker_money_app.core.domain.model.TramoModel
import com.faezolmp.tracker_money_app.core.domain.usecase.UseCase
import com.faezolmp.tracker_money_app.core.utils.DataDummy
import com.faezolmp.tracker_money_app.core.utils.StatusMoney
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import java.util.Date
import java.util.Random

class HomeViewModel(val useCase: UseCase) : ViewModel() {
    private val _data = MutableLiveData<Resource<ExampleModel>>()

    private val _dataState = MutableStateFlow<Resource<List<TramoModel>>>(Resource.Loading())

    private val _dataTransaction = MutableStateFlow<Int>(0)
    val data: LiveData<Resource<ExampleModel>>
        get() = _data

    val dataState: StateFlow<Resource<List<TramoModel>>> = _dataState.asStateFlow()

    val dataTransaction: StateFlow<Int> = _dataTransaction.asStateFlow()

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

            delay(7_000)

//              for see kita berada di thread mana
            Log.d("VIEWMODEL", "Thread: ${Thread.currentThread().name}, DataTransaction: ${dataTransaction} & ${_dataTransaction.value}")

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
                useCase.getAllMoney().collect{data ->
                    _dataState.value = data
//                    _dataTransaction.value = dataState.count()
                }
            }

        }
    }

    fun insetDumyData(){

        viewModelScope.launch(Dispatchers.IO) {
            val i = Random().nextInt(10)
            val dataDumy =  TramoModel(
                uid = 0,
                total = "100000${i}".toLong(),
                statusMoney = if (i % 2 == 0) "in" else "out",
                description = if(i % 2 == 0) "WD Saham" else "Gorengan, Cilok, Martabak",
                date = Date().toString() + Thread.currentThread().name
            )
            useCase.insertMoney(dataDumy)
        }
    }
}