package com.developbharat.facegate.domain.models

import java.time.LocalDateTime

data class FaceMatchSheetRecord(
    val id: Long,
    val personId: Long,
    val isMatched: Boolean,
    val matchScore: Double,
    val frameBase64: String? = null,
    val createdAt: LocalDateTime,
)