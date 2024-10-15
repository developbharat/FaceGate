package com.developbharat.facegate.domain.models

data class AttendanceSheetRecord(
    val personId: Int,
    val batchId: Int,
    val matchScore: Double,
    val frameBase64: String? = null,
)