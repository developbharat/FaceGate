package com.developbharat.facegate.domain.data.database

data class InsertVectorData(
    val id: String, val name: String, val thumbnail: String, val vectors: Iterable<Float>
)

data class SearchVectorData(
    val id: Int, val col1: String, val col2: String, val col3: String, val col4: String, val l2Norm: String
)

interface IVectorsDatabase {
    suspend fun loadDatabase()
    suspend fun searchVectors(vectors: Iterable<Float>, limit: Int = 2): List<SearchVectorData>
    suspend fun insertVectors(vectors: InsertVectorData)
    suspend fun deleteVectors(id: Int)
}