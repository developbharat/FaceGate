package com.developbharat.facegate.domain.ml.facenet

import android.graphics.Bitmap

interface IFaceNetModel {
    suspend fun load()
    suspend fun detect(bitmap: Bitmap): FaceNetResult
    suspend fun close()
}