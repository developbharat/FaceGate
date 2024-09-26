package com.developbharat.facegate.domain.ml

data class FaceNetResult(
    val vectors: List<Float> = emptyList(),
    val elapsedMillis: Long = 0
)