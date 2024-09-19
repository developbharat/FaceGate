package com.developbharat.facegate.domain.models.settings

data class AttendanceSheetOptions(
    val isSuccessMatchFrameStoreEnabled: Boolean = false,
    val isMismatchFrameStoreEnabled: Boolean = false,
    val matchThreshold: Float = 18.0f,
)