package com.developbharat.facegate.domain.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.developbharat.facegate.domain.data.database.entities.BatchRecord

@Dao
interface BatchDao {
    @Query("SELECT * FROM batches;")
    suspend fun list(): List<BatchRecord>

    @Transaction
    @Insert
    suspend fun create(vararg batches: BatchRecord)

    @Delete
    suspend fun delete(batch: BatchRecord)
}