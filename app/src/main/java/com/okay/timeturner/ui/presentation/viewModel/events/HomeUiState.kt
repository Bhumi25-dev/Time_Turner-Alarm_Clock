package com.okay.timeturner.ui.presentation.viewModel.events

import com.okay.timeturner.data.local.AlarmItem

data class HomeUiState(
    val alarms : List<AlarmItem>?,
    val isLoading : Boolean,
    val deletedAlam : AlarmItem?
)
