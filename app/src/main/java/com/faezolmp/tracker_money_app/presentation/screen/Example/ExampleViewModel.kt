package com.faezolmp.tracker_money_app.presentation.screen.Example

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faezolmp.tracker_money_app.core.data.Resource
import com.faezolmp.tracker_money_app.core.domain.model.ExampleModel
import com.faezolmp.tracker_money_app.core.domain.model.TramoModel
import com.faezolmp.tracker_money_app.core.domain.usecase.UseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ExampleViewModel(val useCase: UseCase) : ViewModel() {
    val _data = MutableLiveData<Resource<ExampleModel>>()
    val _dataState = MutableStateFlow<Resource<List<TramoModel>>>(Resource.Loading())
    val data: LiveData<Resource<ExampleModel>>
        get() = _data

    val dataState: StateFlow<Resource<List<TramoModel>>> = _dataState.asStateFlow()

    init {
//        _data.value = useCase.exampleFunction()
        viewModelScope.launch {
            launch(Dispatchers.IO) {
                useCase.getAllMoney().collect { dataResult ->
                    _dataState.value = dataResult
                }
            }
        }
    }
}