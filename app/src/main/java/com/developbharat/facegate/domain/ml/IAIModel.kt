package com.developbharat.facegate.domain.ml

import android.graphics.Bitmap

data class FaceDetectedData(
    val croppedFace: Bitmap, val trackingId: Int = 0
)

data class CalculateVectorsData(
    val vectors: List<Float> = emptyList(), val elapsedMillis: Long = 0, val trackingId: Int = 0
)

interface IAIModel {
    //    suspend fun detectFaces(frame: Bitmap, rotationDegrees: Int): List<FaceDetectedData>
    suspend fun calculateFaceVectors(frame: Bitmap): CalculateVectorsData
    suspend fun calculateFacesVectors(frame: Bitmap): List<CalculateVectorsData>
}