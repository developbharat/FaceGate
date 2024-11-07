package com.developbharat.facegate.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.developbharat.facegate.common.ResourceStatus

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallTopBar(
    title: String,
    subtitle: String? = null,
    actions: @Composable RowScope.() -> Unit = {},
    navigationIcon: @Composable () -> Unit = {},
    status: ResourceStatus? = null,
) {
    Column {
        TopAppBar(
            expandedHeight = TopAppBarDefaults.MediumAppBarCollapsedHeight, title = {
                Column {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    if (subtitle != null) {
                        Text(
                            text = subtitle,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }, navigationIcon = navigationIcon, actions = actions
        )

        // show status card if status is provided.
        if (status != null) SmallTopBarStatusCard(status)
    }
}