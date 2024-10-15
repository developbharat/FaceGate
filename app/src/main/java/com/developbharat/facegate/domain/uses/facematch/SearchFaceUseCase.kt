package com.developbharat.facegate.domain.uses.facematch

import android.graphics.Bitmap
import com.developbharat.facegate.common.Resource
import com.developbharat.facegate.domain.ml.IAIModel
import com.developbharat.facegate.domain.repos.facedb.IFaceDatabaseRepository
import com.developbharat.facegate.domain.repos.facedb.PersonFaceData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchFaceUseCase @Inject constructor(
    private val aiModel: IAIModel, private val faceDbRepository: IFaceDatabaseRepository
) {
    operator fun invoke(frame: Bitmap, minThreshold: Int, maxThreshold: Int): Flow<Resource<PersonFaceData>> = flow {
        try {
            emit(Resource.ResourceInProgress("Searching Face..."))

            // detect and calculate face vectors
            val detection = aiModel.calculateFaceVectors(frame)
            val face = faceDbRepository.searchFace(detection, minThreshold = minThreshold, maxThreshold = maxThreshold)
            
            emit(Resource.ResourceSuccess(face, "Face found."))
        } catch (ex: Exception) {
            emit(Resource.ResourceError(ex.localizedMessage ?: "Unknown Error occurred."))
        }
    }
}