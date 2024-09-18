package com.developbharat.facegate.ui.screens.tabbed.attendance

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.NotStarted
import androidx.compose.material.icons.outlined.SwitchCamera
import androidx.compose.material.icons.outlined.TableView
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.developbharat.facegate.R
import com.developbharat.facegate.ui.components.FaceMatchCard
import com.developbharat.facegate.ui.components.SmallTopBar
import com.developbharat.facegate.ui.components.TabbedBottomBar


@Composable
fun AttendanceScreen(navController: NavController) {
    var isSeeMoreDropdownOpen by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            SmallTopBar(
                title = "Attendance Mode",
                subtitle = "Show your face to start",
                actions = {
                    IconButton(onClick = {}) { Icon(Icons.Outlined.SwitchCamera, contentDescription = "Switch Camera") }
                    IconButton(onClick = { }) {
                        Icon(Icons.Outlined.NotStarted, contentDescription = "Start Attendance")
                    }
                    IconButton(onClick = { isSeeMoreDropdownOpen = true }) {
                        Icon(Icons.Outlined.MoreVert, contentDescription = "See More")
                    }
                    // See more dropdown
                    DropdownMenu(
                        expanded = isSeeMoreDropdownOpen,
                        onDismissRequest = { isSeeMoreDropdownOpen = false }) {
                        DropdownMenuItem(
                            text = { Text("Attendance Sheet") },
                            onClick = { },
                            leadingIcon = { Icon(Icons.Outlined.TableView, contentDescription = "Attendance Sheet") }
                        )
                    }
                })
        },
        bottomBar = { TabbedBottomBar(navController) }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Content
            Box {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "Artist image"
                )

                FaceMatchCard(
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                )
            }
        }
    }
}


