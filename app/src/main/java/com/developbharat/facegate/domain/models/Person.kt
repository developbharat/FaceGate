package com.developbharat.facegate.domain.models

import com.developbharat.facegate.domain.data.database.convertors.LocalDateTimeSerializer
import com.developbharat.facegate.domain.data.database.entities.PeopleRecord
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
data class Person(
    val id: Int,
    val name: String,
    val thumbnail: String,
    val batchId: Int,
    @Serializable(with = LocalDateTimeSerializer::class)
    val createdAt: LocalDateTime
) {
    fun toPeopleRecord(): PeopleRecord {
        return PeopleRecord(
            id = id,
            name = name,
            thumbnail = thumbnail,
            batchId = batchId,
            createdAt = createdAt
        )
    }
}
