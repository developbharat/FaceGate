package com.developbharat.facegate.domain.repos.batch

import com.developbharat.facegate.domain.models.Batch

interface IBatchRepository {
    suspend fun listBatches(): List<Batch>
    suspend fun createBatch(vararg batches: Batch)
    suspend fun deleteBatch(batch: Batch)
}