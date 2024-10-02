package com.faezolmp.tracker_money_app

import android.app.Application
import com.faezolmp.tracker_money_app.core.di.repositoryModule
import com.faezolmp.tracker_money_app.presentation.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication(): Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                listOf(
                    repositoryModule,
                    appModule
                )
            )
        }
    }
}