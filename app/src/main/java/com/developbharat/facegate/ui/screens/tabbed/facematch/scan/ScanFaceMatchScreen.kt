package com.developbharat.facegate.ui.screens.tabbed.facematch.scan

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.SwitchCamera
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.developbharat.facegate.common.toThumbnailBitmap
import com.developbharat.facegate.ui.components.CameraPreview
import com.developbharat.facegate.ui.components.FaceMatchCard
import com.developbharat.facegate.ui.components.SmallTopBar
import com.developbharat.facegate.ui.components.TabbedBottomBar

@Composable
fun ScanFaceMatchScreen(
    navController: NavController,
    viewModel: ScanFaceMatchViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    var isFrontCameraSelected by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            SmallTopBar(
                title = state.selectedPerson.name, subtitle = "ID: ${state.selectedPerson.id}",
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
                actions = {
                    IconButton(onClick = { isFrontCameraSelected = !isFrontCameraSelected }) {
                        Icon(
                            Icons.Outlined.SwitchCamera,
                            contentDescription = "Switch Camera"
                        )
                    }
                }
            )
        },
        bottomBar = { TabbedBottomBar(navController) }) { paddingValues ->
        Surface(modifier = Modifier.padding(paddingValues)) {
            // Content
            Box {
                CameraPreview(
                    isFrontCameraSelected = isFrontCameraSelected,
                    modifier = Modifier.fillMaxSize()
                )

                if (state.match != null) {
                    FaceMatchCard(
                        modifier = Modifier
                            .height(200.dp)
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter),
                        match = state.match
                    )
                }
            }
        }
    }
}