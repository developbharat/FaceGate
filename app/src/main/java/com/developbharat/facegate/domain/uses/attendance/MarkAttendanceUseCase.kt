package com.developbharat.facegate.domain.uses.attendance

import android.graphics.Bitmap
import com.developbharat.facegate.common.Resource
import com.developbharat.facegate.domain.repos.facedb.IFaceDatabaseRepository
import com.developbharat.facegate.domain.repos.facedb.PersonFaceData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarkAttendanceUseCase @Inject constructor(
    private val matchRepository: IFaceDatabaseRepository
) {
    operator fun invoke(frame: Bitmap): Flow<Resource<PersonFaceData>> = flow {
        try {
            emit(Resource.ResourceInProgress("Searching Face..."))
            val match = null as Any as PersonFaceData
            emit(Resource.ResourceSuccess(match, "Attendance marked."))
        } catch (ex: Exception) {
            emit(Resource.ResourceError(ex.localizedMessage ?: "Unknown Error occurred."))
        }
    }
}