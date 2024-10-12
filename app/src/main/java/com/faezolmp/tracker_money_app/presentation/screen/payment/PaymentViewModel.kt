package com.faezolmp.tracker_money_app.presentation.screen.payment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faezolmp.tracker_money_app.core.domain.model.TramoModel
import com.faezolmp.tracker_money_app.core.domain.usecase.UseCase
import com.faezolmp.tracker_money_app.core.utils.FormatDate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date

class PaymentViewModel(private val useCase: UseCase) : ViewModel() {
    fun insertData(
        total: String, description: String, status: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            val date = FormatDate.formatInputDate(Date())
            val data = TramoModel(
                uid = 0, total = total.toLong(), statusMoney = status, description = description, date = date
            )
            useCase.insertMoney(data)
        }
    }
}