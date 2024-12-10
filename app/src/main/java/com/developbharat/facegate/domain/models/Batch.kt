package com.developbharat.facegate.domain.models

import com.developbharat.facegate.domain.data.database.entities.BatchRecord
import java.time.LocalDateTime

data class Batch(
    val id: Int = 0, val name: String, val description: String, val createdAt: LocalDateTime = LocalDateTime.now()
) {
    fun toBatchRecord(): BatchRecord {
        return BatchRecord(id = id, name = name, description = description, createdAt = createdAt)
    }
}