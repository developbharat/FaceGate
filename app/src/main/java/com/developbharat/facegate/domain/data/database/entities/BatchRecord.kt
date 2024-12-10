package com.developbharat.facegate.domain.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.developbharat.facegate.domain.models.Batch
import java.time.LocalDateTime

@Entity("batches")
data class BatchRecord(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "batch_name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "created_at") val createdAt: LocalDateTime = LocalDateTime.now()
) {

    fun toBatch(): Batch {
        return Batch(
            id = id,
            name = name,
            description = description,
            createdAt = createdAt
        )
    }
}