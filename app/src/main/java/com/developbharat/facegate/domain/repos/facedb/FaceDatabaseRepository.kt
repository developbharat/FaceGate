package com.developbharat.facegate.domain.repos.facedb


import com.developbharat.facegate.domain.data.database.IVectorsDatabase
import com.developbharat.facegate.domain.ml.CalculateVectorsData
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject


class FaceDatabaseRepository @Inject constructor(private val database: IVectorsDatabase) : IFaceDatabaseRepository {
    override suspend fun searchFaces(
        data: List<CalculateVectorsData>, minThreshold: Int, maxThreshold: Int
    ): List<PersonFaceData> = coroutineScope {
        data.map { async { searchFace(data = it, minThreshold = minThreshold, maxThreshold = maxThreshold) } }
            .awaitAll()
    }

    override suspend fun searchFace(data: CalculateVectorsData, minThreshold: Int, maxThreshold: Int): PersonFaceData {
        val faces =
            database.searchVectors(vectors = data.vectors, minThreshold = minThreshold, maxThreshold = maxThreshold)
        if (faces.isEmpty()) throw Exception("No matching face found.")

        return faces.first().toPersonFaceData()
    }
}

