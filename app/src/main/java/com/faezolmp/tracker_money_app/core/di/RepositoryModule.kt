package com.faezolmp.tracker_money_app.core.di

import com.faezolmp.tracker_money_app.core.data.ImplRepository
import com.faezolmp.tracker_money_app.core.domain.repository.Repository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
//    single <Repository> { ImplRepository() }
//    or
    singleOf(::ImplRepository) { bind<Repository>() }
}