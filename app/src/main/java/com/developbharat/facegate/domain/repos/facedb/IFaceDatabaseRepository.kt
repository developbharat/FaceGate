package com.developbharat.facegate.domain.repos.facedb

import com.developbharat.facegate.domain.ml.CalculateVectorsData
import com.developbharat.facegate.domain.models.Person


data class PersonFaceData(val person: Person, val matchScore: Float = 0.0f)

interface IFaceDatabaseRepository {
    suspend fun searchFaces(data: List<CalculateVectorsData>, limit: Int): List<PersonFaceData>
    suspend fun searchFace(data: CalculateVectorsData): PersonFaceData
}