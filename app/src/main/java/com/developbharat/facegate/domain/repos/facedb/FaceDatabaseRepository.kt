package com.developbharat.facegate.domain.repos.facedb


import com.developbharat.facegate.domain.ml.CalculateVectorsData
import javax.inject.Inject


class FaceDatabaseRepository @Inject constructor() : IFaceDatabaseRepository {
    override suspend fun searchFaces(data: List<CalculateVectorsData>, limit: Int): List<PersonFaceData> {
        TODO("Not yet implemented")
    }

    override suspend fun searchFace(data: CalculateVectorsData): PersonFaceData {
        TODO("Not yet implemented")
    }

}

