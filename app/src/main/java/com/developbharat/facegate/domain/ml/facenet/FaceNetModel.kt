package com.developbharat.facegate.domain.ml.facenet

import ai.onnxruntime.OnnxTensor
import ai.onnxruntime.OrtEnvironment
import ai.onnxruntime.OrtSession
import android.content.Context
import android.graphics.Bitmap
import android.os.SystemClock
import com.developbharat.facegate.R
import java.nio.FloatBuffer
import java.util.Collections
import javax.inject.Inject


const val DIM_BATCH_SIZE = 1
const val DIM_PIXEL_SIZE = 3
const val IMAGE_SIZE_X = 512
const val IMAGE_SIZE_Y = 512

class FaceNetModel @Inject constructor(
    private val appContext: Context
) : IFaceNetModel {
    private val ortEnvironment: OrtEnvironment = OrtEnvironment.getEnvironment()
    private var ortSession: OrtSession? = null
    private var isModelLoaded: Boolean = false

    override suspend fun load() {
        // Exit if model is already loaded.
        if (isModelLoaded) return

        // Load facenet model for face detection
        val bytes = appContext.resources.openRawResource(R.raw.facenet).readBytes()
        ortSession = ortEnvironment.createSession(bytes)
        isModelLoaded = true
    }

    private fun preProcess(bitmap: Bitmap): FloatBuffer {
        val imgData = FloatBuffer.allocate(
            DIM_BATCH_SIZE * DIM_PIXEL_SIZE * IMAGE_SIZE_X * IMAGE_SIZE_Y
        )
        imgData.rewind()
        val stride = IMAGE_SIZE_X * IMAGE_SIZE_Y
        val bmpData = IntArray(stride)
        bitmap.getPixels(bmpData, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)
        for (i in 0..IMAGE_SIZE_X - 1) {
            for (j in 0..IMAGE_SIZE_Y - 1) {
                val idx = IMAGE_SIZE_Y * i + j
                val pixelValue = bmpData[idx]
                imgData.put(idx, (((pixelValue shr 16 and 0xFF) / 255f - 0.485f) / 0.229f))
                imgData.put(idx + stride, (((pixelValue shr 8 and 0xFF) / 255f - 0.456f) / 0.224f))
                imgData.put(idx + stride * 2, (((pixelValue and 0xFF) / 255f - 0.406f) / 0.225f))
            }
        }

        imgData.rewind()
        return imgData
    }


    private fun bitmapToTensor(bitmap: Bitmap): Map<String?, OnnxTensor> {
        // Resize bitmap and convert to FloatBytes
        val scaled = Bitmap.createScaledBitmap(bitmap, 512, 512, false)
        val tensorData = preProcess(scaled)

        // convert image data to tensor
        val tensorShape =
            longArrayOf(DIM_BATCH_SIZE.toLong(), DIM_PIXEL_SIZE.toLong(), IMAGE_SIZE_X.toLong(), IMAGE_SIZE_Y.toLong())
        val tensor = OnnxTensor.createTensor(ortEnvironment, tensorData, tensorShape)

        val inputName = ortSession?.inputNames?.iterator()?.next()
        val inputs = Collections.singletonMap(inputName, tensor)

        return inputs
    }

    override suspend fun detect(bitmap: Bitmap): FaceNetResult {
        // load if model is not loaded.
        if (!isModelLoaded) load()

        // convert bitmap to required format
        val inputs = bitmapToTensor(bitmap)

        // run model prediction
        val startTime = SystemClock.uptimeMillis()
        val output = ortSession?.run(inputs)
        val processTimeMs = SystemClock.uptimeMillis() - startTime

        val vectors = (output?.get(0)?.value as Array<FloatArray>).first()
        return FaceNetResult(
            vectors = vectors.toList().map { it.toDouble() }, elapsedMillis = processTimeMs
        )
    }

    override suspend fun close() {
        if (!isModelLoaded) return

        ortEnvironment.close()
        isModelLoaded = false
    }
}