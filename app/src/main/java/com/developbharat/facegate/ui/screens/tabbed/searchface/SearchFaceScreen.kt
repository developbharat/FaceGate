package com.developbharat.facegate.ui.screens.tabbed.searchface

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
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
fun SearchFaceScreen(navController: NavController) {
    Scaffold(
        topBar = {
            SmallTopBar(
                title = "Search Face", subtitle = "Show your face to start",
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
            // camera preview and detection result
            Box {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "Artist image"
                )

//                FaceMatchCard(
//                    modifier = Modifier
//                        .height(200.dp)
//                        .fillMaxWidth()
//                        .align(Alignment.BottomCenter),
//                )
            }
        }
    }

}