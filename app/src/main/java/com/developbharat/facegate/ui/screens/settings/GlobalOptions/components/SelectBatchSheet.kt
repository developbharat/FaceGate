package com.developbharat.facegate.ui.screens.settings.GlobalOptions.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.developbharat.facegate.domain.models.Batch

@Composable
fun SelectBatchSheet(batches: List<Batch>, selectedBatchId: Int?, onBatchSelected: (batch: Batch) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
    ) {
        items(batches) { batch ->
            ListItem(
                modifier = Modifier.clickable(
                    true, "Select Batch: ${batch.name}", null, onClick = { onBatchSelected(batch) }),
                headlineContent = { Text(batch.name) },
                supportingContent = { Text(batch.description) },
                trailingContent = {
                    if (selectedBatchId == batch.id) {
                        Icon(Icons.Outlined.Check, contentDescription = "Current Selected Batch.")
                    }
                })
        }
    }
}