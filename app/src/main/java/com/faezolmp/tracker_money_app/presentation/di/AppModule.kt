package com.faezolmp.tracker_money_app.presentation.di

import androidx.lifecycle.ViewModel
import com.faezolmp.tracker_money_app.core.domain.usecase.UseCase
import com.faezolmp.tracker_money_app.core.domain.usecase.UseCaseIteractor
import com.faezolmp.tracker_money_app.presentation.screen.Detail.DetailViewModel
import com.faezolmp.tracker_money_app.presentation.screen.Home.HomeViewModel
import com.faezolmp.tracker_money_app.presentation.screen.payment.PaymentViewModel
import org.koin.androidx.compose.get
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single<UseCase> { UseCaseIteractor(get()) }

//    viewModel<ViewModel> { HomeViewModel(get()) }
    viewModelOf(::HomeViewModel) { bind<ViewModel>() }
//    viewModel<PaymentViewModel>{PaymentViewModel(get())}
    viewModelOf(::PaymentViewModel){bind<ViewModel>()}
//    viewModel<DetailViewModel>{DetailViewModel(get())}
    viewModelOf(::DetailViewModel){bind<ViewModel>()}
}
