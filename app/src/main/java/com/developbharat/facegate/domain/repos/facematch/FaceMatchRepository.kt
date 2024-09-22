package com.developbharat.facegate.domain.repos.facematch

import android.graphics.Bitmap
import com.developbharat.facegate.domain.models.AttendanceSheetRecord
import com.developbharat.facegate.domain.models.FaceMatchSheetRecord
import com.developbharat.facegate.domain.models.FrameFaceMatchStatus
import com.developbharat.facegate.domain.models.Person

class FaceMatchRepository : IFaceMatchRepository {
    override suspend fun searchFace(frame: Bitmap): FrameFaceMatchStatus {
        TODO("Not yet implemented")
    }

    override suspend fun matchPersonFace(person: Person, frame: Bitmap): FrameFaceMatchStatus {
        TODO("Not yet implemented")
    }

    override suspend fun markAttendance(frame: Bitmap): FrameFaceMatchStatus {
        TODO("Not yet implemented")
    }

    override suspend fun createFaceMatchSheetRecord(record: FaceMatchSheetRecord) {
        TODO("Not yet implemented")
    }

}