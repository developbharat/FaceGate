package com.developbharat.facegate.domain.repos.facematch

import android.graphics.Bitmap
import com.developbharat.facegate.domain.models.AttendanceSheetRecord
import com.developbharat.facegate.domain.models.FaceMatchFound
import com.developbharat.facegate.domain.models.FaceMatchSheetRecord
import com.developbharat.facegate.domain.models.Person

class FaceMatchRepository : IFaceMatchRepository {
    override suspend fun searchFace(frame: Bitmap, count: Int): List<FaceMatchFound> {
        TODO("Not yet implemented")
    }

    override suspend fun matchPersonFace(person: Person, frame: Bitmap): FaceMatchFound {
        TODO("Not yet implemented")
    }

    override suspend fun createAttendanceSheetRecord(record: AttendanceSheetRecord) {
        TODO("Not yet implemented")
    }

    override suspend fun createFaceMatchSheetRecord(record: FaceMatchSheetRecord) {
        TODO("Not yet implemented")
    }
}