package com.developbharat.facegate.domain.uses.batch

import com.developbharat.facegate.common.Resource
import com.developbharat.facegate.domain.models.Batch
import com.developbharat.facegate.domain.repos.batch.IBatchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CreateBatchUseCase @Inject constructor(
    private val batchRepository: IBatchRepository
) {
    operator fun invoke(batch: Batch): Flow<Resource<Nothing?>> = flow {
        try {
            emit(Resource.ResourceInProgress("Creating batch..."))
            batchRepository.createBatch(batch)
            emit(Resource.ResourceSuccess(null, "Batch created successful."))
        } catch (ex: Exception) {
            emit(Resource.ResourceError(ex.localizedMessage ?: "Unknown error occurred."))
        }
    }
}