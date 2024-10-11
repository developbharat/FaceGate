package com.developbharat.facegate.domain.models.settings


enum class FaceDetectionMode { FAST, ACCURATE }


data class AdvancedOptions(
    val faceDetectionMode: FaceDetectionMode = FaceDetectionMode.ACCURATE,
    val isFaceTrackingEnabled: Boolean = true
)