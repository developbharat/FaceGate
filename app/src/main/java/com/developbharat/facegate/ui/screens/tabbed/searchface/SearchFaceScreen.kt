package com.developbharat.facegate.ui.screens.tabbed.searchface

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.NotStarted
import androidx.compose.material.icons.outlined.PauseCircleOutline
import androidx.compose.material.icons.outlined.SwitchCamera
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.developbharat.facegate.common.CameraOptions
import com.developbharat.facegate.ui.components.CameraPreview
import com.developbharat.facegate.ui.components.FaceMatchCard
import com.developbharat.facegate.ui.components.SmallTopBar
import com.developbharat.facegate.ui.components.TabbedBottomBar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asExecutor

@Composable
fun SearchFaceScreen(navController: NavController, viewModel: SearchFaceViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    var isFrontCameraSelected by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        CameraOptions.frameAnalysisOptions.setAnalyzer(Dispatchers.Default.asExecutor()) { frame ->
            // detect faces in frame
            viewModel.searchFaceInCameraFrame(frame)
        }
    }


    Scaffold(
        topBar = {
            SmallTopBar(
                title = "Search Face", subtitle = "Search face in selected batch.",
                actions = {
                    IconButton(onClick = { isFrontCameraSelected = !isFrontCameraSelected }) {
                        Icon(
                            Icons.Outlined.SwitchCamera,
                            contentDescription = "Switch Camera"
                        )
                    }

                    if (state.isScanPaused) {
                        IconButton(onClick = { viewModel.setIsScanPaused(false) }) {
                            Icon(
                                Icons.Outlined.NotStarted,
                                contentDescription = "Start Scan Mode",
                            )
                        }
                    } else {
                        IconButton(onClick = { viewModel.setIsScanPaused(true) }) {
                            Icon(
                                Icons.Outlined.PauseCircleOutline,
                                contentDescription = "Pause Scan Mode",
                                tint = Color.Red
                            )
                        }
                    }

                }
            )
        },
        bottomBar = { TabbedBottomBar(navController) }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // camera preview and detection result
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