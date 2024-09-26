package com.developbharat.facegate.domain.repos.facematch

import android.graphics.Bitmap
import com.developbharat.facegate.domain.ml.IFaceNetModel
import com.developbharat.facegate.domain.models.FrameFaceMatchStatus
import com.developbharat.facegate.domain.models.Person
import javax.inject.Inject

class FaceMatchRepository @Inject constructor(
    private val facenetModel: IFaceNetModel
) : IFaceMatchRepository {
    override suspend fun searchFace(frame: Bitmap): FrameFaceMatchStatus {
        TODO("Not yet implemented")
    }

    override suspend fun matchPersonFace(person: Person, frame: Bitmap): FrameFaceMatchStatus {
        TODO("Not yet implemented")
    }

    override suspend fun markAttendance(frame: Bitmap): FrameFaceMatchStatus {
//        val detection = facenetModel.detect(frame)
//        Log.d("vectors", detection.vectors.size.toString())
//        Log.d("elapsedMs", detection.elapsedMillis.toString())
//        return FrameFaceMatchStatus(
//            person = Person(
//                name = "Test",
//                id = "1",
//                thumbnail = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888).toBase64()
//            ), matchScore = 0.0f
//        )
        TODO("Not yet implemented")
    }
}