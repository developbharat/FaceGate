package com.developbharat.facegate.domain.models

import java.time.LocalDateTime

data class FaceMatchSheetRecord(
    val id: String,
    val personId: String,
    val isMatched: Boolean,
    val matchScore: Float,
    val frameBase64: String? = null,
    val createdAt: LocalDateTime,
)