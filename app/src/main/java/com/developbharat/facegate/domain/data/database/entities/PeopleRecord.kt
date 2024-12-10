package com.developbharat.facegate.domain.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.developbharat.facegate.domain.models.Person
import java.time.LocalDateTime

@Entity("people")
data class PeopleRecord(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "thumbnail") val thumbnail: String,
    @ColumnInfo(name = "batch_id") val batchId: Int,
    @ColumnInfo(name = "created_at") val createdAt: LocalDateTime = LocalDateTime.now()
) {

    fun toPerson(): Person {
        return Person(id = id, name = name, thumbnail = thumbnail, batchId = batchId, createdAt = createdAt)
    }
}