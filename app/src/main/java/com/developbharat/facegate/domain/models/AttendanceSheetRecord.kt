package com.developbharat.facegate.domain.models

data class AttendanceSheetRecord(
    val personId: String,
    val batchId: String,
    val matchScore: Float,
    val frameBase64: String? = null,
)