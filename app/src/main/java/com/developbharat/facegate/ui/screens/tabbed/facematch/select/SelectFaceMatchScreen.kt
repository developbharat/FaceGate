package com.developbharat.facegate.ui.screens.tabbed.facematch.select

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.developbharat.facegate.R
import com.developbharat.facegate.common.TabbedScreens
import com.developbharat.facegate.ui.components.SmallTopBar
import com.developbharat.facegate.ui.components.TabbedBottomBar

@Composable
fun SelectFaceMatchScreen(navController: NavController, viewModel: SelectFaceMatchViewModel = hiltViewModel()) {
    val state = viewModel.state.value

    Scaffold(
        topBar = {
            SmallTopBar(
                title = "Select Person", subtitle = "Select a face to start verification",
                navigationIcon = {
                    Image(
                        painter = painterResource(R.drawable.ic_launcher_foreground),
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
            LazyColumn {
                items(state.people) { person ->
                    ListItem(
                        headlineContent = { Text(person.name) },
                        supportingContent = { Text("ID: ${person.id}") },
                        leadingContent = {
                            Image(
                                bitmap = person.thumbnail.asImageBitmap(),
                                modifier = Modifier.size(width = 50.dp, height = 50.dp),
                                contentDescription = "Person Picture"
                            )
                        },
                        trailingContent = {
                            IconButton(onClick = {
                                navController.navigate(TabbedScreens.ScanFaceMatchScreen(person = person))
                            }) {
                                Icon(
                                    Icons.Outlined.CameraAlt,
                                    contentDescription = "Match Person Face"
                                )
                            }
                        }
                    )
                    HorizontalDivider()
                }
            }
        }
    }

}