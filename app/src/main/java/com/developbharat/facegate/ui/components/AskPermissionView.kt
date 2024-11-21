package com.developbharat.facegate.ui.components

import android.Manifest
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.developbharat.facegate.ui.theme.FaceGateTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun AskPermissionView(
    permission: String,
    explainRequestReason: String,
    forwardToSettingsReason: String,
    onGranted: () -> Unit,
    modifier: Modifier = Modifier
) {
    val cameraPermissionState = rememberPermissionState(permission)
    if (cameraPermissionState.status.isGranted) {
        onGranted()
    } else {
        Column(modifier = modifier) {
            val textToShow = if (cameraPermissionState.status.shouldShowRationale) {
                forwardToSettingsReason
            } else {
                explainRequestReason
            }

            Text(textToShow)
            Spacer(modifier = Modifier.height(8.dp))
            Button(modifier = Modifier.fillMaxWidth(), onClick = { cameraPermissionState.launchPermissionRequest() }) {
                Text("Grant Permission")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AskPermissionViewPreview() {
    FaceGateTheme {
        AskPermissionView(
            permission = Manifest.permission.CAMERA,
            explainRequestReason = "Please allow us camera permission",
            forwardToSettingsReason = "Camera permission is required to continue.",
            onGranted = {})
    }
}