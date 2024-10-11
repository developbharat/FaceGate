package com.developbharat.facegate.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Person(
<<<<<<< HEAD
    val id: Long,
=======
    val id: Int,
>>>>>>> 6b4b84b (started refactoring app code)
    val name: String,
    val thumbnail: String,
)
