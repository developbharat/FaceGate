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
fun AdvancedOptions() {
    Column {
        Text(
            "Advanced Options",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )

        ListItem(
            headlineContent = { Text("Face Detection Mode") },
            supportingContent = { Text("Selected: Performance Mode / Accurate Mode") },
            trailingContent = {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Outlined.Edit,
                        contentDescription = "Set Performance Mode or Accurate Mode"
                    )
                }
            }
        )

        ListItem(
            headlineContent = { Text("Face Tracking") },
            supportingContent = { Text("Enabled") },
            trailingContent = {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Outlined.Edit,
                        contentDescription = "Enable or Disable face tracking in multiple frames"
                    )
                }
            }
        )
    }
}