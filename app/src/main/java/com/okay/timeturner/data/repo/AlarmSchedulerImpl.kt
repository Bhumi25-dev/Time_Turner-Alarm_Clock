package com.okay.timeturner.data.repo

import android.Manifest
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.annotation.RequiresPermission
import com.okay.timeturner.data.local.AlarmItem
import com.okay.timeturner.receiver.AlarmReceiver
import kotlin.jvm.java

class AlarmSchedulerImpl (
    private val context: Context
) : AlarmScheduler {

    //1.Summon the Alarm manager service
    private val alarmManager = context.getSystemService(AlarmManager::class.java)

    @RequiresPermission(Manifest.permission.SCHEDULE_EXACT_ALARM)
    override fun schedule(alarmItem: AlarmItem) {
        //2.Draft the intent pointing to the AlarmReceiver
        val intent = Intent(context, AlarmReceiver::class.java).apply {
            putExtra("ExtraAlarm", alarmItem.alarmId)
        }

        //3.Seal it in a pending intent
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            alarmItem.alarmId,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        // 4. Fire the Engine using setAlarmClock
        val alarmClock = AlarmManager.AlarmClockInfo(alarmItem.timeInMillis, null)

        alarmManager.setAlarmClock(alarmClock,pendingIntent) //handed off the pending intent to the Android OS

    }

    override fun cancel(alarmItem: AlarmItem) {

        val intent = Intent(context, AlarmReceiver::class.java)

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            alarmItem.alarmId,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        alarmManager.cancel(pendingIntent)

    }
}