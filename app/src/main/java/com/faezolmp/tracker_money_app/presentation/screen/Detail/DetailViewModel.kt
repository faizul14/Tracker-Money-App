package com.faezolmp.tracker_money_app.presentation.screen.Detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faezolmp.tracker_money_app.core.domain.model.TramoModel
import com.faezolmp.tracker_money_app.core.domain.usecase.UseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(private val useCase: UseCase) : ViewModel() {
    fun deleteItemTransaction(data: TramoModel) {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.deleteMoney(data)
        }
    }
}