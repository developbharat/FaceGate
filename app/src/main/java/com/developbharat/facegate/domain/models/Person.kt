package com.developbharat.facegate.domain.models

import android.graphics.Bitmap
import com.developbharat.facegate.domain.serializers.BitmapSerializer
import kotlinx.serialization.Serializable

@Serializable
data class Person(
    val id: String,
    val name: String,
    @Serializable(with = BitmapSerializer::class) val thumbnail: Bitmap,
)