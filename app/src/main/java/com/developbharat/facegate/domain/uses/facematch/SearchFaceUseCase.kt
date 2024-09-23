package com.developbharat.facegate.domain.uses.facematch

import androidx.camera.core.ImageProxy
import com.developbharat.facegate.common.Resource
import com.developbharat.facegate.domain.models.FrameFaceMatchStatus
import com.developbharat.facegate.domain.repos.facematch.IFaceMatchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchFaceUseCase @Inject constructor(
    val matchRepository: IFaceMatchRepository
) {
    operator fun invoke(frame: ImageProxy): Flow<Resource<FrameFaceMatchStatus>> = flow {
        try {
            emit(Resource.ResourceInProgress("Searching Face..."))
            val match = matchRepository.searchFace(frame.toBitmap())
            emit(Resource.ResourceSuccess(match, "Face found."))
        } catch (ex: Exception) {
            emit(Resource.ResourceError(ex.localizedMessage ?: "Unknown Error occurred."))
        }
    }
}