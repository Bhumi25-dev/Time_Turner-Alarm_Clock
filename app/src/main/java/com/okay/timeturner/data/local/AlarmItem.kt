package com.okay.timeturner.data.local

data class AlarmItem(
    val alarmId: Int,
    val alarmTitle: String,
    val timeInMillis: Long,
    val alarmMessage: String? = null
)