package com.okay.timeturner.data.repo

import com.okay.timeturner.data.local.AlarmItem

interface AlarmScheduler {
    fun schedule(alarmItem: AlarmItem)
    fun cancel(alarmItem: AlarmItem)
}