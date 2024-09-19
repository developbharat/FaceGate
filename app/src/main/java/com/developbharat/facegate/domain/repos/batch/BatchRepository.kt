package com.developbharat.facegate.domain.repos.batch

import android.graphics.Bitmap
import com.developbharat.facegate.domain.models.Batch
import com.developbharat.facegate.domain.models.Person

class BatchRepository : IBatchRepository {
    override suspend fun listBatchPeople(): List<Person> {
        return listOf(
            Person(
                id = "1",
                name = "John Doe",
                thumbnail = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888)
            )
        )
    }

    override suspend fun createBatch(batch: Batch) {
        TODO("Not yet implemented")
    }

    override suspend fun setBatchActive() {
        TODO("Not yet implemented")
    }
}