package com.okay.timeturner.ui.presentation.viewModel.events

import com.okay.timeturner.data.local.AlarmItem

sealed interface HomeEvent {
    data object UndoDelete : HomeEvent
    data class DeleteAlarm(val alarmItem: AlarmItem) : HomeEvent
    data class ToggleAlarm(val alarmItem: AlarmItem,val enabled : Boolean) : HomeEvent
}