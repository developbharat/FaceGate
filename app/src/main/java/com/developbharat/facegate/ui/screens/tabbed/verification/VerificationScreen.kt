package com.developbharat.facegate.ui.screens.tabbed.verification

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.developbharat.facegate.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerificationScreen() {
    Column {
        TopAppBar(modifier = Modifier.height(64.dp),
            navigationIcon = {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "Face Gate"
                )
            },
            title = {
                Column {
                    Text(
                        text = "Select Person",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Select a face to start verification",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            })

        LazyColumn {
            item {
                ListItem(
                    headlineContent = { Text("Person Name") },
                    supportingContent = { Text("ID: 30132022") },
                    leadingContent = {
                        Image(
                            painter = painterResource(R.drawable.ic_launcher_foreground),
                            modifier = Modifier.size(width = 50.dp, height = 50.dp),
                            contentDescription = "Person Picture"
                        )
                    },
                    trailingContent = {
                        IconButton(onClick = {}) {
                            Icon(
                                Icons.Outlined.CameraAlt,
                                contentDescription = "Verify Person Name"
                            )
                        }
                    }

                )
                HorizontalDivider()
            }

            item {
                ListItem(
                    headlineContent = { Text("Person Name") },
                    supportingContent = { Text("ID: 30132022") },
                    leadingContent = {
                        Image(
                            painter = painterResource(R.drawable.ic_launcher_foreground),
                            modifier = Modifier.size(width = 50.dp, height = 50.dp),
                            contentDescription = "Person Picture"
                        )
                    },
                    trailingContent = {
                        IconButton(onClick = {}) {
                            Icon(
                                Icons.Outlined.CameraAlt,
                                contentDescription = "Verify Person Name"
                            )
                        }
                    }

                )
                HorizontalDivider()
            }
        }
    }
}