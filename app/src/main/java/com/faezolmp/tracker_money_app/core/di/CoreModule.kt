package com.faezolmp.tracker_money_app.core.di

import androidx.room.Room
import com.faezolmp.tracker_money_app.core.data.resource.local.room.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localModule = module {
    factory { get<AppDatabase>().tramoDao() }

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "apdatabase.db"
        ).fallbackToDestructiveMigration().build()
    }
}