package com.developbharat.facegate.domain.repos.facematch

import android.graphics.Bitmap
import com.developbharat.facegate.domain.models.AttendanceSheetRecord
import com.developbharat.facegate.domain.models.FaceMatchFound
import com.developbharat.facegate.domain.models.FaceMatchSheetRecord
import com.developbharat.facegate.domain.models.Person

interface IFaceMatchRepository {
    suspend fun searchFace(frame: Bitmap, count: Int = 1): List<FaceMatchFound>
    suspend fun matchPersonFace(person: Person, frame: Bitmap): FaceMatchFound
    suspend fun createAttendanceSheetRecord(record: AttendanceSheetRecord)
    suspend fun createFaceMatchSheetRecord(record: FaceMatchSheetRecord)
}