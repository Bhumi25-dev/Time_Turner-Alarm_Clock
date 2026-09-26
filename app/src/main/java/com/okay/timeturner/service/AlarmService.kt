package com.okay.timeturner.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import androidx.core.app.NotificationCompat
import com.okay.timeturner.R
import com.okay.timeturner.RingingActivity

class AlarmService : Service() {

    private var mediaPlayer: MediaPlayer? = null
    private var vibrator: Vibrator? = null

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        createNotificationChannel()

        val ringingIntent = Intent(this, RingingActivity::class.java).apply {
            this.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = PendingIntent.getActivity(
            this,0,ringingIntent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        val chosenTune = intent?.getIntExtra("ServiceTuneId",R.raw.harry_potter_original)?: R.raw.harry_potter_original

        val notification = NotificationCompat.Builder(this, "ALARM_CHANNEL_ID")
            .setSmallIcon(android.R.drawable.ic_lock_idle_alarm)
            .setContentTitle("Time Turner")
            .setContentText("Wake up!")
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setCategory(NotificationCompat.CATEGORY_ALARM)
            .setFullScreenIntent(pendingIntent, true) // Force lock screen bypass
            .build()

        startForeground(1,notification)

        startAlarmAndVibration(chosenTune)

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.apply {
            if (isPlaying) stop()
            release()
        }
        mediaPlayer = null
        vibrator?.cancel()
        vibrator = null
    }

    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            "ALARM_CHANNEL_ID",
            "Alarm Notifications",
            NotificationManager.IMPORTANCE_HIGH
        ).apply {
            setSound(null, null)
        }

        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.createNotificationChannel(channel)
    }

    private fun startAlarmAndVibration(tuneResId: Int) {
        mediaPlayer = MediaPlayer.create(this, tuneResId)?.apply {
            isLooping = true
            start()
        }

        val vibratorManager = getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
        val vibrator = vibratorManager.defaultVibrator

        val pattern = longArrayOf(0,500,500)
        vibrator.vibrate(VibrationEffect.createWaveform(pattern,0))
    }
}