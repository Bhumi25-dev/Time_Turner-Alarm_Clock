package com.okay.timeturner.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.okay.timeturner.R
import com.okay.timeturner.service.AlarmService

class AlarmReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?,intent: Intent?) {
        if(intent?.action == Intent.ACTION_BOOT_COMPLETED)
        {
            Log.d("AlarmReceiver", "Device rebooted! Time to reschedule alarms.")
            // TODO: Launch a background coroutine to fetch alarms from Room DB
            // TODO: Loop through them and schedule them again with AlarmManager
        } else {
            Log.d("AlarmReceiver", "Alarm triggered! Waking up the user.")
            val tuneId = intent?.getIntExtra("ExtraTuneId", R.raw.harry_potter_original)?:R.raw.harry_potter_original
            val serviceIntent = Intent(context, AlarmService::class.java).apply {
                putExtra("ServiceTuneId",tuneId)
            }
            context?.startForegroundService(serviceIntent)
        }
    }
}