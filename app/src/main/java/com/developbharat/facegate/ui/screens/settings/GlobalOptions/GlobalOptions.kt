package com.developbharat.facegate.ui.screens.settings.GlobalOptions

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.developbharat.facegate.ui.screens.settings.GlobalOptions.components.SelectBatchSheet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GlobalOptions() {
    var showSelectBatchSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    Column {
        Text(
            "Global Options", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary
        )

        if (showSelectBatchSheet) {
            ModalBottomSheet(
                onDismissRequest = { showSelectBatchSheet = false },
                sheetState = sheetState
                // TODO: update it from view model
            ) { SelectBatchSheet(batches = emptyList(), selectedBatchId = null, onBatchSelected = {}) }
        }

        ListItem(
            headlineContent = { Text("Selected Batch") },
            supportingContent = { Text("No Batch selected!") },
            trailingContent = {
                IconButton(onClick = { showSelectBatchSheet = true }) {
                    Icon(
                        Icons.Outlined.Edit, contentDescription = "Select Active Batch"
                    )
                }
            })
    }
}