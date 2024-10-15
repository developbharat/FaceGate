package com.developbharat.facegate.domain.data.database

import com.developbharat.facegate.domain.models.Person
import com.developbharat.facegate.domain.repos.facedb.PersonFaceData

data class InsertVectorData(
    val id: Int, val name: String, val thumbnail: String, val vectors: Iterable<Float>
)

data class SearchVectorResult(
    val id: Int,
    val name: String,
    val thumbnail: String,
    val matchScore: Float
) {
    fun toPersonFaceData(): PersonFaceData {
        val person = Person(id = id, name = name, thumbnail = thumbnail)
        return PersonFaceData(person = person, matchScore = matchScore)
    }
}

interface IVectorsDatabase {
    suspend fun searchVectors(vectors: Iterable<Double>, minThreshold: Int, maxThreshold: Int): List<SearchVectorResult>
    suspend fun insertVectors(data: InsertVectorData)
    suspend fun deleteVectors(id: Int)
}