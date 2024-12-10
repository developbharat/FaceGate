package com.developbharat.facegate.domain.uses.batch

import com.developbharat.facegate.common.Resource
import com.developbharat.facegate.domain.models.Batch
import com.developbharat.facegate.domain.repos.batch.IBatchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ListBatchesUseCase @Inject constructor(
    private val batchRepository: IBatchRepository
) {
    operator fun invoke(): Flow<Resource<List<Batch>>> = flow {
        try {
            emit(Resource.ResourceInProgress("Creating batch..."))
            val batches = batchRepository.listBatches()
            emit(Resource.ResourceSuccess(batches))
        } catch (ex: Exception) {
            emit(Resource.ResourceError(ex.localizedMessage ?: "Unknown error occurred."))
        }
    }
}
