package com.faezolmp.tracker_money_app.core.data.resource.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.faezolmp.tracker_money_app.core.data.resource.local.entity.TramoEntity

@Database(entities = [TramoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun tramoDao(): TramoDao
}