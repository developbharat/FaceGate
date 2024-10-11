package com.developbharat.facegate.domain.ml.facenet

data class FaceNetResult(
    val vectors: List<Double> = emptyList(),
    val elapsedMillis: Long = 0
)