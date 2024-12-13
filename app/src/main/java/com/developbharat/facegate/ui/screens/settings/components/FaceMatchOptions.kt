package com.developbharat.facegate.ui.screens.settings.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType
import com.developbharat.facegate.domain.models.settings.FaceMatchOptions

@Composable
fun FaceMatchOptions(options: FaceMatchOptions, onUpdate: (options: FaceMatchOptions) -> Unit) {
    Column {
        Text(
            "Face Match",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )

        ListItem(
            headlineContent = { Text("Capture frame for Match") },
            supportingContent = { Text("Selected: " + if (options.isSuccessMatchFrameStoreEnabled) "Yes" else "No") },
            trailingContent = {
                Switch(
                    checked = options.isSuccessMatchFrameStoreEnabled,
                    onCheckedChange = { onUpdate(options.copy(isSuccessMatchFrameStoreEnabled = !options.isSuccessMatchFrameStoreEnabled)) })
            }
        )


        ListItem(
            headlineContent = { Text("Capture frame for Mismatch") },
            supportingContent = { Text("Selected: " + if (options.isMismatchFrameStoreEnabled) "Yes" else "No") },
            trailingContent = {
                Switch(
                    checked = options.isMismatchFrameStoreEnabled,
                    onCheckedChange = { onUpdate(options.copy(isMismatchFrameStoreEnabled = !options.isMismatchFrameStoreEnabled)) })
            }
        )

        EditableFieldListItem(
            headline = "Match Threshold",
            placeholder = "Value between 1-100",
            selectedValue = options.matchThreshold.toString(),
            keyboardType = KeyboardType.Decimal,
            isValueValid = { it.toFloatOrNull() != null && it.toFloat() >= 1 && it.toFloat() <= 100 },
            onSave = { onUpdate(options.copy(matchThreshold = it.toFloat())) })
    }
}