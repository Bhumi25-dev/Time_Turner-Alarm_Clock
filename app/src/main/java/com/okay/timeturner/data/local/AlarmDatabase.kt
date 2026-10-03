package com.okay.timeturner.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AlarmItem::class], version = 1)
abstract class AlarmDatabase: RoomDatabase() {
    abstract val alarmDao: AlarmDao
}