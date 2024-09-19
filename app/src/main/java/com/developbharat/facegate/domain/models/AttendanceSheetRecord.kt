package com.developbharat.facegate.domain.models

import android.graphics.Bitmap
import java.time.LocalDateTime

data class AttendanceSheetRecord(
    val id: String,
    val personId: String,
    val batchId: String,
    val matchScore: Float,
    val frame: Bitmap? = null,
    val createdAt: LocalDateTime,
)