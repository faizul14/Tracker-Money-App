package com.faezolmp.tracker_money_app.presentation.screen.Home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.faezolmp.tracker_money_app.core.data.Resource
import com.faezolmp.tracker_money_app.core.domain.model.ExampleModel
import com.faezolmp.tracker_money_app.core.domain.usecase.UseCase

class HomeViewModel(val useCase: UseCase): ViewModel(){
    private val _data = MutableLiveData<Resource<ExampleModel>>()
    val data: LiveData<Resource<ExampleModel>>
        get() = _data

    init {
        _data.value = useCase.exampleFunction()
    }
}