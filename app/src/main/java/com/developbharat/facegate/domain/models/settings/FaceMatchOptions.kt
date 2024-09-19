package com.developbharat.facegate.domain.models.settings

data class FaceMatchOptions(
    val isSuccessMatchFrameStoreEnabled: Boolean = false,
    val isMismatchFrameStoreEnabled: Boolean = true,
    val matchThreshold: Float = 18.0f,
)