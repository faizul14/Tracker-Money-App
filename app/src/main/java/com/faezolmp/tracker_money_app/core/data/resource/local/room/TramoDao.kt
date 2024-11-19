package com.faezolmp.tracker_money_app.core.data.resource.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.faezolmp.tracker_money_app.core.data.resource.local.entity.TramoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TramoDao {
    @Query("SELECT * FROM tramoentity")
    fun getAllMoney(): Flow<List<TramoEntity>>

    @Query("SELECT * FROM tramoentity WHERE status_money = :status")
    fun getMoneyByIn(status: String = "in"): Flow<List<TramoEntity>>

    @Query("SELECT * FROM tramoentity WHERE status_money = :status")
    fun getMoneyByOut(status: String = "out"): Flow<List<TramoEntity>>

    @Insert
    suspend fun insetMoney(data: TramoEntity)

    @Update
    fun updateMoney(data: TramoEntity)

    @Delete
    suspend fun deleteMoney(data: TramoEntity)
}