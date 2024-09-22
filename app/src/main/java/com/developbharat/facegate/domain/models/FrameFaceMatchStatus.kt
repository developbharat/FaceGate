package com.developbharat.facegate.domain.models

data class FrameFaceMatchStatus(
    val person: Person,
    val matchScore: Float = 0.0f
) {
    fun toAttendanceRecord(batchId: String, frame: String): AttendanceSheetRecord {
        return AttendanceSheetRecord(
            personId = person.id,
            batchId = batchId,
            matchScore = matchScore,
            frameBase64 = frame,
        )
    }

}