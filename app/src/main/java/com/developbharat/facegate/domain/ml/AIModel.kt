package com.developbharat.facegate.domain.ml

import android.graphics.Bitmap
import android.graphics.Rect
import com.developbharat.facegate.domain.ml.facenet.IFaceNetModel
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.face.FaceDetection
import com.google.mlkit.vision.face.FaceDetectorOptions
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class AIModel @Inject constructor(private val faceNetModel: IFaceNetModel) : IAIModel {
    // High-accuracy landmark detection and face classification
    // TODO: compile these options dynamically based on AdvancedSettings.
    val highAccuracyOpts =
        FaceDetectorOptions.Builder().setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_ACCURATE)
            .setLandmarkMode(FaceDetectorOptions.LANDMARK_MODE_ALL)
            .setClassificationMode(FaceDetectorOptions.CLASSIFICATION_MODE_ALL).build()
    private val detector = FaceDetection.getClient(highAccuracyOpts)


    private suspend fun detectFaces(frame: Bitmap): List<FaceDetectedData> =
        suspendCancellableCoroutine { continuation ->
            val inputImage = InputImage.fromBitmap(frame, 0)
            detector.process(inputImage).addOnSuccessListener { faces ->
                val detections = faces.map { face ->
                    // Get the bounding box of the detected face
                    val boundingBox: Rect = face.boundingBox

                    // Ensure the bounding box is within the bitmap's dimensions
                    val x = boundingBox.left.coerceAtLeast(0)
                    val y = boundingBox.top.coerceAtLeast(0)
                    val width = boundingBox.width().coerceAtMost(frame.width - x)
                    val height = boundingBox.height().coerceAtMost(frame.height - y)

                    // Crop the bitmap using the bounding box
                    val croppedFaceBitmap = Bitmap.createBitmap(frame, x, y, width, height)
                    FaceDetectedData(croppedFace = croppedFaceBitmap, trackingId = face.trackingId ?: 0)
                }

                // resolve with detections
                continuation.resume(detections)
            }.addOnFailureListener { e -> continuation.resumeWithException(e) }
        }


    override suspend fun calculateFaceVectors(frame: Bitmap): CalculateVectorsData {
        val detections = detectFaces(frame)
        if (detections.size != 1) throw Exception("Multiple faces detected in frame")

        val detection = detections.first()
        val output = faceNetModel.detect(detection.croppedFace)
        return CalculateVectorsData(
            vectors = output.vectors, elapsedMillis = output.elapsedMillis, trackingId = detection.trackingId
        )

    }

    override suspend fun calculateFacesVectors(frame: Bitmap): List<CalculateVectorsData> {
        val detections = detectFaces(frame)

        return detections.map { detection ->
            val output = faceNetModel.detect(detection.croppedFace)
            CalculateVectorsData(
                vectors = output.vectors, elapsedMillis = output.elapsedMillis, trackingId = detection.trackingId
            )
        }
    }
}