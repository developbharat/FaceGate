package com.developbharat.facegate.common

import androidx.camera.core.ImageAnalysis

object CameraOptions {
    val frameAnalysisOptions = ImageAnalysis.Builder()
        .setOutputImageFormat(ImageAnalysis.OUTPUT_IMAGE_FORMAT_YUV_420_888)
        .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
        .build()
}