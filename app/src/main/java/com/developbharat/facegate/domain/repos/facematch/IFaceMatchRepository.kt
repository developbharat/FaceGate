package com.developbharat.facegate.domain.repos.facematch

import android.graphics.Bitmap
import com.developbharat.facegate.domain.models.AttendanceSheetRecord
import com.developbharat.facegate.domain.models.FaceMatchSheetRecord
import com.developbharat.facegate.domain.models.FrameFaceMatchStatus
import com.developbharat.facegate.domain.models.Person

interface IFaceMatchRepository {
    suspend fun searchFace(frame: Bitmap): FrameFaceMatchStatus
    suspend fun matchPersonFace(person: Person, frame: Bitmap): FrameFaceMatchStatus
    suspend fun markAttendance(frame: Bitmap): FrameFaceMatchStatus
    suspend fun createFaceMatchSheetRecord(record: FaceMatchSheetRecord)
}