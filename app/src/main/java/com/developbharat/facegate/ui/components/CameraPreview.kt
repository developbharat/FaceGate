package com.developbharat.facegate.ui.components


import android.content.Context
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import androidx.camera.core.Camera
import androidx.camera.core.CameraSelector.DEFAULT_BACK_CAMERA
import androidx.camera.core.CameraSelector.DEFAULT_FRONT_CAMERA
import androidx.camera.core.FocusMeteringAction
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.developbharat.facegate.common.CameraOptions
import java.util.concurrent.TimeUnit
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


@Composable
fun CameraPreview(
    modifier: Modifier = Modifier,
    frameAnalyzer: ImageAnalysis = CameraOptions.frameAnalysisOptions,
    isFrontCameraSelected: Boolean = true,
) {
    val side =
        if (isFrontCameraSelected) {
            DEFAULT_FRONT_CAMERA
        } else {
            DEFAULT_BACK_CAMERA
        }


    val lifecycleOwner = androidx.lifecycle.compose.LocalLifecycleOwner.current
    val context = LocalContext.current
    val preview = Preview.Builder().build()
    val previewView = remember { PreviewView(context) }


    // Enable camera zoom
    LaunchedEffect(side) {
        val cameraProvider = context.getCameraProvider()
        cameraProvider.unbindAll()
        val camera = cameraProvider.bindToLifecycle(lifecycleOwner, side, frameAnalyzer, preview)
        preview.setSurfaceProvider(previewView.surfaceProvider)

        // setup zoom and touch
        setupZoomAndTapToFocus(previewView, camera)
    }

    Surface(modifier = modifier) {
        AndroidView(factory = { previewView }, modifier = Modifier.fillMaxSize())
    }
}


private suspend fun Context.getCameraProvider(): ProcessCameraProvider =
    suspendCoroutine { continuation ->
        ProcessCameraProvider.getInstance(this).also { cameraProvider ->
            cameraProvider.addListener(
                { continuation.resume(cameraProvider.get()) },
                ContextCompat.getMainExecutor(this)
            )
        }
    }

fun setupZoomAndTapToFocus(cameraView: PreviewView, camera: Camera) {
    val listener = object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            val currentZoomRatio: Float = camera.cameraInfo.zoomState.value?.zoomRatio ?: 1F
            val delta = detector.scaleFactor
            camera.cameraControl.setZoomRatio(currentZoomRatio * delta)
            return true
        }
    }

    val scaleGestureDetector = ScaleGestureDetector(cameraView.context, listener)

    cameraView.setOnTouchListener { _, event ->
        scaleGestureDetector.onTouchEvent(event)
        if (event.action == MotionEvent.ACTION_DOWN) {
            cameraView.performClick()
            val factory = cameraView.meteringPointFactory
            val point = factory.createPoint(event.x, event.y)
            val action = FocusMeteringAction.Builder(point, FocusMeteringAction.FLAG_AF)
                .setAutoCancelDuration(5, TimeUnit.SECONDS)
                .build()
            camera.cameraControl.startFocusAndMetering(action)
        }
        true
    }
}
