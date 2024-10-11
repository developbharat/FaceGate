package com.developbharat.facegate.ui.screens.tabbed.attendance

import com.developbharat.facegate.common.ResourceStatus
import com.developbharat.facegate.domain.repos.facedb.PersonFaceData

data class AttendanceState(
    val match: PersonFaceData? = null,
    val status: ResourceStatus = ResourceStatus(),
    val isScanPaused: Boolean = true,
)