package com.okay.timeturner.di

import android.content.Context
import androidx.room.Room
import com.okay.timeturner.data.local.AlarmDao
import com.okay.timeturner.data.local.AlarmDatabase
import com.okay.timeturner.data.repo.AlarmScheduler
import com.okay.timeturner.data.repo.AlarmSchedulerImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindsAlarmScheduler(
        impl: AlarmSchedulerImpl
    ) : AlarmScheduler

    @Provides
    @Singleton
    fun provideAlarmDatabase(
        @ApplicationContext context : Context
    ) : AlarmDatabase
    {
        return Room.databaseBuilder(
            context,
            AlarmDatabase::class.java,
            "alarm_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideAlarmDao(database: AlarmDatabase) : AlarmDao {
        return database.alarmDao
    }

}