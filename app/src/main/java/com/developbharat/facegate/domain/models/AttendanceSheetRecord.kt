package com.developbharat.facegate.domain.models

data class AttendanceSheetRecord(
    val personId: Long,
    val batchId: Long,
    val matchScore: Double,
    val frameBase64: String? = null,
)