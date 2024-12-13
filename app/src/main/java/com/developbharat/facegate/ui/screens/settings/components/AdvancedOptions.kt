package com.developbharat.facegate.ui.screens.settings.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.developbharat.facegate.domain.models.settings.AdvancedOptions
import com.developbharat.facegate.domain.models.settings.FaceDetectionMode

@Composable
fun AdvancedOptions(options: AdvancedOptions, onUpdate: (options: AdvancedOptions) -> Unit) {
    Column {
        Text(
            "Advanced Options",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )

        ListItem(
            headlineContent = { Text("Face Detection Mode") },
            supportingContent = {
                Text(if (options.faceDetectionMode == FaceDetectionMode.ACCURATE) "Accurate Mode" else "Performance Mode")
            },
            trailingContent = {
                Switch(
                    checked = options.faceDetectionMode == FaceDetectionMode.ACCURATE,
                    onCheckedChange = { onUpdate(options.copy(faceDetectionMode = if (options.faceDetectionMode == FaceDetectionMode.ACCURATE) FaceDetectionMode.FAST else FaceDetectionMode.ACCURATE)) })
            }
        )

        ListItem(
            headlineContent = { Text("Face Tracking") },
            supportingContent = { Text("Selected: " + if (options.isFaceTrackingEnabled) "Enabled" else "Disabled") },
            trailingContent = {
                Switch(
                    checked = options.isFaceTrackingEnabled,
                    onCheckedChange = { onUpdate(options.copy(isFaceTrackingEnabled = !options.isFaceTrackingEnabled)) })
            }
        )
    }
}