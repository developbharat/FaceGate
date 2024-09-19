package com.developbharat.facegate.ui.screens.tabbed.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.developbharat.facegate.R
import com.developbharat.facegate.common.Screens
import com.developbharat.facegate.ui.components.SmallTopBar
import com.developbharat.facegate.ui.components.TabbedBottomBar

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            SmallTopBar(title = "Home", subtitle = "Welcome to Face Gate", navigationIcon = {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "Home"
                )
            })
        },
        bottomBar = { TabbedBottomBar(navController) }) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            // Action Buttons
            // TODO: in future we might have this screen dedicated to dashboard and graphs,
            // and these buttons might shift to top app bar actions
            Column(modifier = Modifier.padding(10.dp)) {
                Button(modifier = Modifier.fillMaxWidth(), onClick = {}) { Text("Download Faces") }
                Button(modifier = Modifier.fillMaxWidth(), onClick = {}) { Text("Manage Storage ") }
                Button(modifier = Modifier.fillMaxWidth(), onClick = {
                    navController.navigate(Screens.SettingsScreen)
                }) { Text("Settings") }
                Button(modifier = Modifier.fillMaxWidth(), onClick = {
                    navController.navigate(Screens.SetActiveBatchScreen)
                }) { Text("Select Active Batch") }

                Button(modifier = Modifier.fillMaxWidth(), onClick = {
                    navController.navigate(Screens.CreateBatchScreen)
                }) { Text("Create Batch") }
            }
        }
    }

}