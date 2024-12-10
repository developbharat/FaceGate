package com.developbharat.facegate.domain.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.developbharat.facegate.domain.data.database.entities.PeopleRecord

@Dao
interface PeopleDao {
    @Query("SELECT * FROM people WHERE batch_id=:batchId AND id=:personId;")
    suspend fun find(batchId: Int, personId: Int): PeopleRecord?

    @Query("SELECT * FROM people WHERE batch_id=:batchId;")
    suspend fun list(batchId: Int): List<PeopleRecord>

    @Transaction
    @Insert
    suspend fun create(vararg people: PeopleRecord)

    @Delete
    suspend fun delete(people: PeopleRecord)

}