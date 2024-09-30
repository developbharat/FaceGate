package com.developbharat.facegate.domain.ml

data class FaceNetResult(
    val vectors: List<Double> = emptyList(),
    val elapsedMillis: Long = 0
)