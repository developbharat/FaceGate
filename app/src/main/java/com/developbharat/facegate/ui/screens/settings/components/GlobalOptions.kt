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
fun GlobalOptions() {
    Column {
        Text(
            "Global Options",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )

        ListItem(
            headlineContent = { Text("Model Release") },
            supportingContent = { Text("Selected: 1.0") },
            trailingContent = {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Outlined.Edit,
                        contentDescription = "Set Model Release"
                    )
                }
            }
        )


        ListItem(
            headlineContent = { Text("Selected Batch") },
            supportingContent = { Text("No Batch selected!") },
            trailingContent = {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Outlined.Edit,
                        contentDescription = "Select Active Batch"
                    )
                }
            }
        )
    }
}