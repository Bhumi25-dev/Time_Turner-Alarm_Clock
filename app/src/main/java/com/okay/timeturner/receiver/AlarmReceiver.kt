package com.okay.timeturner.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class AlarmReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context,intent: Intent) {
        if(intent.action == Intent.ACTION_BOOT_COMPLETED)
        {
            Log.d("AlarmReceiver", "Device rebooted! Time to reschedule alarms.")
            // TODO: Launch a background coroutine to fetch alarms from Room DB
            // TODO: Loop through them and schedule them again with AlarmManager
        } else {
            Log.d("AlarmReceiver", "Alarm triggered! Waking up the user.")
            // TODO: Start your Foreground Service to play the Harry Potter audio
        }
    }
}