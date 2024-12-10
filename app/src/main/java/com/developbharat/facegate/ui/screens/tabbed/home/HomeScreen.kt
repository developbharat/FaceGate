package com.developbharat.facegate.ui.screens.tabbed.home

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.developbharat.facegate.R
import com.developbharat.facegate.common.Screens
import com.developbharat.facegate.ui.components.SmallTopBar
import com.developbharat.facegate.ui.components.TabbedBottomBar

@Composable
fun HomeScreen(
    navController: NavController, viewModel: HomeViewModel = hiltViewModel(), context: Context = LocalContext.current
) {
    val state = viewModel.state.value

    Scaffold(topBar = {
        SmallTopBar(
            title = "Home", subtitle = "Welcome to Face Gate", navigationIcon = {
                Image(painter = painterResource(R.drawable.ic_launcher_foreground), contentDescription = "Home")
            }, status = state.status
        )
    }, bottomBar = { TabbedBottomBar(navController) }) { paddingValues ->
        Surface(modifier = Modifier.padding(paddingValues)) {
            Column(modifier = Modifier.padding(10.dp)) {
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
                        navController.navigate(Screens.CreateBatchScreen)
                    }) { Text("Create Batch") }
                }
            }
        }
    }
}