package com.developbharat.facegate.ui.screens.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.developbharat.facegate.R
import com.developbharat.facegate.ui.components.SmallTopBar

@Composable
fun SettingsScreen() {
    Scaffold(topBar = {
        SmallTopBar(title = "Settings", subtitle = "Fine tune app options", navigationIcon = {
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground), contentDescription = "Settings"
            )
        })
    }) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Column(modifier = Modifier.padding(10.dp)) {
                // Global Options
                Text("Global Options")
                Text("Model Release: [Select] (Default 1.0)")
                Text("Selected Batch: [Select] (Default null)")
                HorizontalDivider()

                // Options related to Face Match
                Text("Face Match")
                Text("Should we store Frame for Successful Match: (Default False)")
                Text("Should we store Frame for Mismatch: (Default True)")
                Text("Match Threshold: (Default 18)")

                HorizontalDivider()

                // Options related to Attendance Sheet
                Text("Attendance")
                Text("Should we store Frame for Successful Match: (Default False)")
                Text("Should we store Frame for Mismatch: (Default False)")
                Text("Match Threshold: (Default 18)")
            }
        }
    }
}