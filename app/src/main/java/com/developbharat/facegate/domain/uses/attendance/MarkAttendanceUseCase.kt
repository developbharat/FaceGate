package com.developbharat.facegate.domain.uses.attendance

import android.graphics.Bitmap
import com.developbharat.facegate.common.Resource
import com.developbharat.facegate.domain.models.FrameFaceMatchStatus
import com.developbharat.facegate.domain.repos.facematch.IFaceMatchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarkAttendanceUseCase @Inject constructor(
    private val matchRepository: IFaceMatchRepository
) {
    operator fun invoke(frame: Bitmap): Flow<Resource<FrameFaceMatchStatus>> = flow {
        try {
            emit(Resource.ResourceInProgress("Searching Face..."))
            val match = matchRepository.markAttendance(frame)
            emit(Resource.ResourceSuccess(match, "Attendance marked."))
        } catch (ex: Exception) {
            emit(Resource.ResourceError(ex.localizedMessage ?: "Unknown Error occurred."))
        }
    }
}