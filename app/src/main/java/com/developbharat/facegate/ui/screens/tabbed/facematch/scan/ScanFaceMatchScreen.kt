package com.developbharat.facegate.ui.screens.tabbed.facematch.scan

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.developbharat.facegate.ui.components.SmallTopBar
import com.developbharat.facegate.ui.components.TabbedBottomBar

@Composable
fun ScanFaceMatchScreen(
    navController: NavController,
    viewModel: ScanFaceMatchViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Scaffold(
        topBar = {
            SmallTopBar(
                title = "Face Match", subtitle = "[${state.selectedPerson.id}]: ${state.selectedPerson.name}",
                navigationIcon = {
                    Image(
                        bitmap = state.selectedPerson.thumbnail.asImageBitmap(),
                        contentDescription = "Face Gate"
                    )
                },
            )
        },
        bottomBar = { TabbedBottomBar(navController) }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Text("Camera Preview will appear here.")
        }
    }
}