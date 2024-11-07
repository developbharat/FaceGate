package com.developbharat.facegate.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.developbharat.facegate.common.ResourceStatus


@Composable
fun SmallTopBarStatusCard(status: ResourceStatus) {
    var isStatusVisible by remember { mutableStateOf(true) }

    if (isStatusVisible) {
        Column {
            // Loading state
            if (status.isInProgress) {
                Card(
                    shape = RectangleShape, colors = CardDefaults.cardColors().copy(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                        text = status.statusText,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    LinearProgressIndicator(modifier = Modifier.fillMaxWidth(), strokeCap = StrokeCap.Square)
                }
            }

            // Error State
            if (status.isError) {
                Card(
                    shape = RectangleShape, colors = CardDefaults.cardColors().copy(
                        containerColor = MaterialTheme.colorScheme.errorContainer,
                        contentColor = MaterialTheme.colorScheme.onErrorContainer
                    )
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                            text = status.statusText,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                        )

                        IconButton(onClick = { isStatusVisible = false }) {
                            Icon(Icons.Outlined.Close, contentDescription = "Close")
                        }
                    }
                }
            }


            // Success state
            if (status.isSuccess) {
                Card(
                    shape = RectangleShape, colors = CardDefaults.cardColors().copy(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                            text = status.statusText,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                        )

                        IconButton(onClick = { isStatusVisible = false }) {
                            Icon(Icons.Outlined.Close, contentDescription = "Close")
                        }
                    }
                }
            }
        }
    }
}