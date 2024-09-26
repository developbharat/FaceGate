package com.developbharat.facegate.domain.ml

import android.graphics.Bitmap

interface IFaceNetModel {
    suspend fun load()
    suspend fun detect(bitmap: Bitmap): FaceNetResult
    suspend fun close()
}