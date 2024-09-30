package com.developbharat.facegate.domain.repos.facematch

import android.graphics.Bitmap
import com.developbharat.facegate.domain.data.ISQLiteDatabase
import com.developbharat.facegate.domain.data.searchVector
import com.developbharat.facegate.domain.ml.IFaceNetModel
import com.developbharat.facegate.domain.models.FrameFaceMatchStatus
import com.developbharat.facegate.domain.models.Person
import com.developbharat.facegate.domain.models.settings.AttendanceSheetOptions
import javax.inject.Inject

class FaceMatchRepository @Inject constructor(
    private val facenetModel: IFaceNetModel,
    private val database: ISQLiteDatabase,
    private val attendanceSheetOptions: AttendanceSheetOptions
) : IFaceMatchRepository {
    override suspend fun searchFace(frame: Bitmap): FrameFaceMatchStatus {
        TODO("Not yet implemented")
    }

    override suspend fun matchPersonFace(person: Person, frame: Bitmap): FrameFaceMatchStatus {
        TODO("Not yet implemented")
    }

    override suspend fun markAttendance(frame: Bitmap): FrameFaceMatchStatus {
        // calculate vectors from face
        val detection = facenetModel.detect(frame)

        // check if face exists in database
        val dbMatch = database.vectorsDao.searchVector(detection.vectors)
        if (dbMatch == null || dbMatch.l2norm > attendanceSheetOptions.matchThreshold.toDouble()) {
            throw Exception("No match found for captured face.")
        }

        // search for person in database and return match result
        val person = database.peopleDao.findById(dbMatch.person_id).executeAsOne()
        return FrameFaceMatchStatus(
            person = Person(
                name = person.name,
                id = person.id,
                thumbnail = person.thumbnail_b64,
            ),
            matchScore = dbMatch.l2norm,
            detectionMillis = detection.elapsedMillis
        )
    }
}