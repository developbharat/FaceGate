package com.developbharat.facegate.ui.screens.tabbed.attendance

import android.Manifest
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.NotStarted
import androidx.compose.material.icons.outlined.PauseCircleOutline
import androidx.compose.material.icons.outlined.SwitchCamera
import androidx.compose.material.icons.outlined.TableView
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.developbharat.facegate.common.CameraOptions
import com.developbharat.facegate.ui.components.AskPermissionView
import com.developbharat.facegate.ui.components.CameraPreview
import com.developbharat.facegate.ui.components.FaceMatchCard
import com.developbharat.facegate.ui.components.SmallTopBar
import com.developbharat.facegate.ui.components.TabbedBottomBar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asExecutor


/**
 * TODO: pending actions
 * 1. Show a already attendance marked for person, who visits again
 * 2. Show Errors if it occurs
 */

@Composable
fun AttendanceScreen(
    navController: NavController, viewModel: AttendanceViewModel = hiltViewModel()
) {
    val localContext = LocalContext.current
    val state = viewModel.state.value
    var isFrontCameraSelected by remember { mutableStateOf(true) }
    var isSeeMoreDropdownOpen by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        // check if camera permission is granted.
        viewModel.checkAndUpdateCameraPermission(localContext)

        // initialise camerax api to receive frames
        CameraOptions.frameAnalysisOptions.setAnalyzer(Dispatchers.Default.asExecutor()) { frame ->
            viewModel.executeScanOperation(frame)
        }
    }

    Scaffold(topBar = {
        SmallTopBar(
            title = "Attendance Mode",
            subtitle = if (state.isScanPaused) "Press Play icon to start scan" else "Press Pause icon to stop scan",
            actions = {
                IconButton(onClick = { isFrontCameraSelected = !isFrontCameraSelected }) {
                    Icon(
                        Icons.Outlined.SwitchCamera, contentDescription = "Switch Camera"
                    )
                }
                if (state.isScanPaused) {
                    IconButton(onClick = { viewModel.setIsScanPaused(false) }) {
                        Icon(
                            Icons.Outlined.NotStarted,
                            contentDescription = "Start Attendance",
                        )
                    }
                } else {
                    IconButton(onClick = { viewModel.setIsScanPaused(true) }) {
                        Icon(
                            Icons.Outlined.PauseCircleOutline, contentDescription = "Pause Attendance", tint = Color.Red
                        )
                    }
                }


                IconButton(onClick = { isSeeMoreDropdownOpen = true }) {
                    Icon(Icons.Outlined.MoreVert, contentDescription = "See More")
                }

                // See more dropdown
                DropdownMenu(
                    expanded = isSeeMoreDropdownOpen, onDismissRequest = { isSeeMoreDropdownOpen = false }) {
                    DropdownMenuItem(text = { Text("Attendance Sheet") }, onClick = {
                        /** TODO: Add onClick */
                    }, leadingIcon = {
                        Icon(
                            Icons.Outlined.TableView, contentDescription = "Attendance Sheet"
                        )
                    })
                }
            })
    }, bottomBar = { TabbedBottomBar(navController) }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            if (!state.isCameraPermissionGranted) {
                AskPermissionView(
                    modifier = Modifier.padding(10.dp),
                    permission = Manifest.permission.CAMERA,
                    explainRequestReason = "Could you please grant permission for camera access? We need it for our face scanning feature.",
                    forwardToSettingsReason = "Ah, it looks like we're missing permission to access your camera. Don't worry! We need camera access for our special facial scanning feature to work.",
                    onGranted = { viewModel.checkAndUpdateCameraPermission(localContext) })
            } else {
                // Content
                Box {
                    CameraPreview(
                        isFrontCameraSelected = isFrontCameraSelected, modifier = Modifier.fillMaxSize()
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
}


