package com.developbharat.facegate.domain.repos.batch

import com.developbharat.facegate.domain.models.Batch
import com.developbharat.facegate.domain.models.Person

interface IBatchRepository {
    suspend fun listBatchPeople(): List<Person>
    suspend fun createBatch(batch: Batch)
    suspend fun setBatchActive()
}