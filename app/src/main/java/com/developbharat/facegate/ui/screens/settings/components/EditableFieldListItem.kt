package com.developbharat.facegate.ui.screens.settings.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun EditableFieldListItem(
    headline: String,
    placeholder: String,
    selectedValue: String,
    keyboardType: KeyboardType,
    isValueValid: (value: String) -> Boolean,
    onSave: (value: String) -> Unit
) {
    var isInputEditable by remember { mutableStateOf(false) }
    var isInputInvalid by remember { mutableStateOf(false) }
    var inputValue by remember { mutableStateOf(selectedValue) }

    ListItem(
        headlineContent = { Text(headline) },
        supportingContent = {
            if (isInputEditable) {
                OutlinedTextField(
                    value = inputValue,
                    onValueChange = { inputValue = it },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
                    placeholder = { Text(placeholder) },
                    singleLine = true,
                    isError = isInputInvalid
                )
            } else {
                Text("Selected: $selectedValue")
            }
        },
        trailingContent = {
            if (isInputEditable) {
                IconButton(onClick = {
                    if (!isValueValid(inputValue)) {
                        isInputInvalid = true
                    } else {
                        isInputEditable = false
                        isInputInvalid = false
                        onSave(inputValue)
                    }
                }) {
                    Icon(
                        Icons.Outlined.Check,
                        contentDescription = "Save"
                    )
                }
            } else {
                IconButton(onClick = { isInputEditable = true }) {
                    Icon(
                        Icons.Outlined.Edit,
                        contentDescription = "Edit"
                    )
                }
            }
        }
    )
}