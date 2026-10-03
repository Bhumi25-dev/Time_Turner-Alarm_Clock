package com.okay.timeturner.data.repo

import android.Manifest
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.provider.Settings
import androidx.annotation.RequiresPermission
import com.okay.timeturner.data.local.AlarmItem
import com.okay.timeturner.receiver.AlarmReceiver
import dagger.hilt.android.qualifiers.ApplicationContext
import jakarta.inject.Inject

class AlarmSchedulerImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : AlarmScheduler {

    //1.Summon the Alarm manager service
    private val alarmManager = context.getSystemService(AlarmManager::class.java)

    @RequiresPermission(Manifest.permission.SCHEDULE_EXACT_ALARM)
    override fun schedule(alarmItem: AlarmItem) {
        if(alarmManager.canScheduleExactAlarms()) {
            //2.Draft the intent pointing to the AlarmReceiver
            val intent = Intent(context, AlarmReceiver::class.java).apply {
                putExtra("ExtraAlarm", alarmItem.alarmId)
                putExtra("ExtraTuneId",alarmItem.tuneResId)
            }
            //3.Seal it in a pending intent
            val pendingIntent = PendingIntent.getBroadcast(
                context,
                alarmItem.alarmId,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
            // 4. Fire the Engine using setAlarmClock
            val alarmClock = AlarmManager.AlarmClockInfo(alarmItem.timeInMillis, pendingIntent)

            alarmManager.setAlarmClock(alarmClock, pendingIntent)
        } else {
            val intent = Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM).apply{
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context.startActivity(intent)
        }
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