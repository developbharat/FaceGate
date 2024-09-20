package com.developbharat.facegate.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Person(
    val id: String,
    val name: String,
    val thumbnail: String,
)
