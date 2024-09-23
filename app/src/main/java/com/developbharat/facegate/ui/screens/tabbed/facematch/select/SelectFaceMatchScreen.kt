package com.developbharat.facegate.ui.screens.tabbed.facematch.select

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AutoAwesomeMosaic
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.QrCode
import androidx.compose.material.icons.outlined.SwitchCamera
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import com.developbharat.facegate.common.TabbedScreens
import com.developbharat.facegate.common.toThumbnailBitmap
import com.developbharat.facegate.ui.components.CameraPreview
import com.developbharat.facegate.ui.components.SmallTopBar
import com.developbharat.facegate.ui.components.TabbedBottomBar

@Composable
fun SelectFaceMatchScreen(navController: NavController, viewModel: SelectFaceMatchViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    var isScanQrModeEnabled by remember { mutableStateOf(false) }
    var isFrontCameraSelected by remember { mutableStateOf(true) }

    Scaffold(topBar = {
        SmallTopBar(title = "Match Face 1:1", subtitle = "Select Record or Scan QR", actions = {
            if (isScanQrModeEnabled) {
                IconButton(onClick = { isFrontCameraSelected = !isFrontCameraSelected }) {
                    Icon(
                        Icons.Outlined.SwitchCamera, contentDescription = "Switch Camera"
                    )
                }
            }

            if (isScanQrModeEnabled) {
                IconButton(onClick = { isScanQrModeEnabled = false }) {
                    Icon(
                        Icons.Outlined.AutoAwesomeMosaic,
                        contentDescription = "Select List Item Mode",
                    )
                }
            } else {
                IconButton(onClick = { isScanQrModeEnabled = true }) {
                    Icon(
                        Icons.Outlined.QrCode,
                        contentDescription = "Scan QR Code Mode",
                    )
                }
            }

        })
    }, bottomBar = { TabbedBottomBar(navController) }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            if (isScanQrModeEnabled) {
                Box {
                    CameraPreview(
                        isFrontCameraSelected = isFrontCameraSelected, modifier = Modifier.fillMaxSize()
                    )

                    Card(
                        modifier = Modifier
                            .height(200.dp)
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter),
                    ) {
                        Text("Scanned Result will appear here in a card.")
                    }
                }
            }

            if (!isScanQrModeEnabled) {
                LazyColumn {
                    items(state.people) { person ->
                        ListItem(headlineContent = { Text(person.name) },
                            supportingContent = { Text("ID: ${person.id}") },
                            leadingContent = {
                                Image(
                                    bitmap = person.thumbnail.toThumbnailBitmap().asImageBitmap(),
                                    modifier = Modifier
                                        .size(width = 50.dp, height = 50.dp)
                                        .clip(CircleShape),
                                    contentDescription = "${person.name} Face"
                                )
                            },
                            trailingContent = {
                                IconButton(onClick = {
                                    navController.navigate(TabbedScreens.ScanFaceMatchScreen(person = person))
                                }) {
                                    Icon(
                                        Icons.Outlined.CameraAlt, contentDescription = "Match Person Face"
                                    )
                                }
                            })
                        HorizontalDivider()
                    }
                }
            }
        }
    }
}