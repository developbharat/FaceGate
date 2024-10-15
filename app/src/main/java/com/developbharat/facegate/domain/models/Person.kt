package com.developbharat.facegate.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Person(
    val id: Int,
    val name: String,
    val thumbnail: String,
)
