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
import com.developbharat.facegate.domain.models.settings.GlobalOptions
import com.developbharat.facegate.ui.screens.settings.GlobalOptions.components.SelectBatch.SelectBatchSheet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GlobalOptions(options: GlobalOptions, onUpdate: (options: GlobalOptions) -> Unit) {
    var showSelectBatchSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    Column {
        Text(
            "Global Options", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary
        )

        if (showSelectBatchSheet) {
            ModalBottomSheet(
                onDismissRequest = { showSelectBatchSheet = false }, sheetState = sheetState
            ) {
                SelectBatchSheet(
                    selectedBatchId = options.selectedBatchId,
                    onBatchSelected = { onUpdate(options.copy(selectedBatchId = it.id)) })
            }
        }
        // TODO: fix this hardcoded text "No Batch selected"
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