package com.developbharat.facegate.domain.data.vectors

data class InsertVectorData(val contentId: String, val vectors: Iterable<Float>)

data class SearchVectorResult(
    val id: Int,
    val contentId: String,
    val matchScore: Float
)


interface IVectorsDatabase {
    suspend fun searchVectors(vectors: Iterable<Double>, minThreshold: Int, maxThreshold: Int): List<SearchVectorResult>
    suspend fun insertVectors(data: InsertVectorData)
    suspend fun deleteVectors(id: Int)
}