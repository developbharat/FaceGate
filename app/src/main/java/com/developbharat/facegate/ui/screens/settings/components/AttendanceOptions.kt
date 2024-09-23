package com.developbharat.facegate.ui.screens.settings.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun AttendanceOptions() {
    Column {
        Text(
            "Attendance",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )

        ListItem(
            headlineContent = { Text("Capture frame for Match") },
            supportingContent = { Text("Selected: No") },
            trailingContent = {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Outlined.Edit,
                        contentDescription = "Set Store camera frame for successful match."
                    )
                }
            }
        )


        ListItem(
            headlineContent = { Text("Capture frame for Mismatch") },
            supportingContent = { Text("Selected: False") },
            trailingContent = {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Outlined.Edit,
                        contentDescription = "Set Store camera frame for mismatch"
                    )
                }
            }
        )

        ListItem(
            headlineContent = { Text("Match Threshold") },
            supportingContent = { Text("Selected: 18") },
            trailingContent = {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Outlined.Edit,
                        contentDescription = "Set Match Threshold"
                    )
                }
            }
        )

    }
}