package com.developbharat.facegate.ui.screens.tabbed.attendance

import com.developbharat.facegate.common.ResourceStatus
import com.developbharat.facegate.domain.models.FrameFaceMatchStatus

data class AttendanceState(
    val match: FrameFaceMatchStatus? = null,
    val status: ResourceStatus = ResourceStatus(),
    val isScanPaused: Boolean = true,
)