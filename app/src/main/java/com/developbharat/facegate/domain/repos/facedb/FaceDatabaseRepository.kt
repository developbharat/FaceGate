package com.developbharat.facegate.domain.repos.facedb


import com.developbharat.facegate.domain.data.database.MainDatabase
import com.developbharat.facegate.domain.data.vectors.IVectorsDatabase
import com.developbharat.facegate.domain.ml.CalculateVectorsData
import com.developbharat.facegate.domain.repos.device.IDeviceState
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject


class FaceDatabaseRepository @Inject constructor(
    private val vectorsDatabase: IVectorsDatabase,
    private val mainDatabase: MainDatabase,
    private val deviceState: IDeviceState
) : IFaceDatabaseRepository {
    override suspend fun searchFaces(
        data: List<CalculateVectorsData>, minThreshold: Int, maxThreshold: Int
    ): List<PersonFaceData> = coroutineScope {
        data.map { async { searchFace(data = it, minThreshold = minThreshold, maxThreshold = maxThreshold) } }
            .awaitAll()
    }

    override suspend fun searchFace(data: CalculateVectorsData, minThreshold: Int, maxThreshold: Int): PersonFaceData {
        // find matching vectors
        val vectorsResult =
            vectorsDatabase.searchVectors(
                vectors = data.vectors,
                minThreshold = minThreshold,
                maxThreshold = maxThreshold
            )
        if (vectorsResult.isEmpty()) throw Exception("No matching face found.")
        val vectorData = vectorsResult.first()

        // find current selected batch.
        val batchId = deviceState.useGlobalOptions().selectedBatchId
        if (batchId == null) throw Exception("No batch selected. Please select a batch in settings.")

        // find person with matching face.
        val dbPerson = mainDatabase.peopleDao().find(batchId.toInt(), vectorData.contentId.toInt())
        if (dbPerson == null) throw Exception("No matching face found. Looks like the record was deleted.")

        return PersonFaceData(person = dbPerson.toPerson(), matchScore = vectorData.matchScore)
    }
}

