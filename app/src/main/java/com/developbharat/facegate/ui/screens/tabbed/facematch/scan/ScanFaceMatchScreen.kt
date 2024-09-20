package com.developbharat.facegate.ui.screens.tabbed.facematch.scan

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.developbharat.facegate.common.toThumbnailBitmap
import com.developbharat.facegate.ui.components.SmallTopBar
import com.developbharat.facegate.ui.components.TabbedBottomBar

@Composable
fun ScanFaceMatchScreen(
    navController: NavController,
    viewModel: ScanFaceMatchViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value

    Scaffold(
        topBar = {
            SmallTopBar(
                title = state.selectedPerson.name, subtitle = "ID: state.selectedPerson.id",
                navigationIcon = {
                    Image(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(CircleShape)
                            .size(40.dp),
                        bitmap = state.selectedPerson.thumbnail.toThumbnailBitmap().asImageBitmap(),
                        contentDescription = "${state.selectedPerson.name} Face"
                    )
                },
            )
        },
        bottomBar = { TabbedBottomBar(navController) }) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Column(modifier = Modifier.padding(10.dp)) {
                Text("Camera Preview will appear here.")
            }
        }
    }
}