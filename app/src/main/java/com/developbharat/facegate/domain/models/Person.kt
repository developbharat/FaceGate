package com.developbharat.facegate.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Person(
    val id: Long,
    val name: String,
    val thumbnail: String,
)
