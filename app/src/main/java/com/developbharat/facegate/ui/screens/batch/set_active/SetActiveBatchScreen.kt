package com.developbharat.facegate.ui.screens.batch.set_active

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.developbharat.facegate.ui.components.SmallTopBar


@Composable
fun SetActiveBatchScreen() {
    Scaffold(topBar = {
        SmallTopBar(
            title = "Update Active Batch",
            subtitle = "Faces are grouped in Batches"
        )
    }) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            item {
                ListItem(
                    headlineContent = { Text("Batch 1") },
                    supportingContent = { Text("Supporting Content") },
                    overlineContent = { Text("Currently Active", color = Color.Green) },
                    trailingContent = {
                        OutlinedButton(onClick = {}) { Text("Set Active") }
                    })
            }
        }
    }
}