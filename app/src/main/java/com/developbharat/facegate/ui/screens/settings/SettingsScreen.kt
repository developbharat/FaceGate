package com.developbharat.facegate.ui.screens.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.developbharat.facegate.ui.components.SmallTopBar
import com.developbharat.facegate.ui.screens.settings.components.AdvancedOptions
import com.developbharat.facegate.ui.screens.settings.components.AttendanceOptions
import com.developbharat.facegate.ui.screens.settings.components.FaceMatchOptions
import com.developbharat.facegate.ui.screens.settings.components.GlobalOptions
import com.developbharat.facegate.ui.screens.settings.components.SettingsSectionSpacer

@Composable
fun SettingsScreen() {
    Scaffold(topBar = {
        SmallTopBar(title = "Settings", subtitle = "Fine tune app options")
    }) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            LazyColumn(modifier = Modifier.padding(10.dp)) {
                item {
                    GlobalOptions()
                    SettingsSectionSpacer()
                }

                item {
                    FaceMatchOptions()
                    SettingsSectionSpacer()
                }

                item {
                    AttendanceOptions()
                }

                item {
                    AdvancedOptions()
                }
            }
        }
    }
}
