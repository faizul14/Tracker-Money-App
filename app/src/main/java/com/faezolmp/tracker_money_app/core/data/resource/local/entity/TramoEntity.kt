package com.faezolmp.tracker_money_app.core.data.resource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tramoentity")
data class TramoEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "uid") val uid: Int = 0,
    @ColumnInfo(name = "total") val total: Long?,
    @ColumnInfo(name = "status_money") val statusMoney: String?, // in / out
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "date") val date: String?,
)
