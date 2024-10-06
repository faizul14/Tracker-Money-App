package com.faezolmp.tracker_money_app.presentation.screen.Home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faezolmp.tracker_money_app.core.data.Resource
import com.faezolmp.tracker_money_app.core.domain.model.ExampleModel
import com.faezolmp.tracker_money_app.core.domain.model.TramoModel
import com.faezolmp.tracker_money_app.core.domain.usecase.UseCase
import com.faezolmp.tracker_money_app.core.utils.StatusMoney
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(val useCase: UseCase) : ViewModel() {
    private val _data = MutableLiveData<Resource<ExampleModel>>()

    private val _dataState = MutableStateFlow<Resource<List<TramoModel>>>(Resource.Loading())
    val data: LiveData<Resource<ExampleModel>>
        get() = _data

    val dataState: StateFlow<Resource<List<TramoModel>>> = _dataState.asStateFlow()

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

//              insert aoutomation dummy data to local dababase

//            launch(Dispatchers.IO) {
//                DataDummy.dataDummyToDB().collect { data ->
//                    useCase.insertMoney(data)
//                }
//            }

            delay(7_000)

//              for see kita berada di thread mana
            Log.d("VIEWMODEL", "Thread: ${Thread.currentThread().name}")

//              for get all data money
//            useCase.getAllMoney().collect { data ->
//                _dataState.value = data
//            }

//            for get data money by status in
            useCase.getMoneyByStatus(StatusMoney.IN).collect { data ->
                _dataState.value = data
            }
//            for get data money by status out
//            useCase.getMoneyByStatus(StatusMoney.OUT).collect{data ->
//                _dataState.value = data
//            }
        }
    }
}