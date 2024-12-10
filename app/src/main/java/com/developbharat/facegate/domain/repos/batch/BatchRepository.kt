package com.developbharat.facegate.domain.repos.batch

import com.developbharat.facegate.domain.data.database.MainDatabase
import com.developbharat.facegate.domain.models.Batch
import javax.inject.Inject

class BatchRepository @Inject constructor(
    val db: MainDatabase
) : IBatchRepository {
    override suspend fun listBatches(): List<Batch> {
        return db.batchDao().list().map { it.toBatch() }
    }

    override suspend fun createBatch(vararg batches: Batch) {
        db.batchDao().create(*batches.map { it.toBatchRecord() }.toTypedArray())
    }

    override suspend fun deleteBatch(batch: Batch) {
        db.batchDao().delete(batch.toBatchRecord())
    }
}