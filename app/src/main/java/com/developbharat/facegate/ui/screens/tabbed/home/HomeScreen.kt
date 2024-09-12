package com.developbharat.facegate.ui.screens.tabbed.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
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
fun HomeScreen() {
    Column {
        TopAppBar(modifier = Modifier.height(64.dp),
            navigationIcon = {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "Home"
                )
            },
            title = {
                Column {
                    Text(
                        text = "Home",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Welcome to Face Gate",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            })

        // Action Buttons
        // TODO: in future we might have this screen dedicated to dashboard and graphs,
        // and these buttons might shift to top app bar actions
        Column(modifier = Modifier.padding(10.dp)) {
            Button(modifier = Modifier.fillMaxWidth(), onClick = {}) { Text("Download Faces") }
            Button(modifier = Modifier.fillMaxWidth(), onClick = {}) { Text("Manage Storage ") }
            Button(modifier = Modifier.fillMaxWidth(), onClick = {}) { Text("Settings") }
        }
    }
}