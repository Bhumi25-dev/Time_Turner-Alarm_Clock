package com.okay.timeturner.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.okay.timeturner.R

@Entity(tableName = "alarms")
data class AlarmItem(
    @PrimaryKey(autoGenerate = true)
    val alarmId: Int,
    val alarmTitle: String,
    val timeInMillis: Long,
    val alarmMessage: String? = null,
    val tuneResId: Int = R.raw.harry_potter_original
)