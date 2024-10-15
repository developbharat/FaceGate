package com.developbharat.facegate.domain.models

data class FrameFaceMatchStatus(
    val person: Person,
    val matchScore: Double = 0.0,
    val detectionMillis: Long = 0,
) {
    fun toAttendanceRecord(batchId: Int, frame: String): AttendanceSheetRecord {
        return AttendanceSheetRecord(
            personId = person.id,
            batchId = batchId,
            matchScore = matchScore,
            frameBase64 = frame,
        )
    }

}