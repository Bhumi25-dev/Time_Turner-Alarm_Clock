package com.okay.timeturner.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AlarmDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlarm(alarmItem: AlarmItem)

    @Delete
    suspend fun deleteAlarm(alarmItem: AlarmItem)

    @Query("SELECT * FROM alarms")
    fun getAllAlarms(): Flow<List<AlarmItem>>

    @Query("SELECT * FROM alarms WHERE alarmId = :id")
    suspend fun getAlarmById(id: Int): AlarmItem?

}