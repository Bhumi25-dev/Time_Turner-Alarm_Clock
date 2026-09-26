package com.okay.timeturner.data.repo

import com.okay.timeturner.data.local.AlarmDao
import com.okay.timeturner.data.local.AlarmItem
import kotlinx.coroutines.flow.Flow

class AlarmRepo(
    private val alarmDao : AlarmDao
) {

    val alarmList : Flow<List<AlarmItem>> = alarmDao.getAllAlarms()

    suspend fun insertAlarm(alarmItem: AlarmItem){
        alarmDao.insertAlarm(alarmItem)
    }

    suspend fun deleteAlarm(alarmItem: AlarmItem){
        alarmDao.deleteAlarm(alarmItem)
    }

    suspend fun getAlarmById(id: Int): AlarmItem?{
        return alarmDao.getAlarmById(id)
    }
}