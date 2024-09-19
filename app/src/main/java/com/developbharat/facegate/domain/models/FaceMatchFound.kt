package com.developbharat.facegate.domain.models

data class FaceMatchFound(
    val person: Person,
    val matchScore: Float,
)