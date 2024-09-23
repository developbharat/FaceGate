package com.developbharat.facegate.ui.screens.settings.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsSectionSpacer() {
    HorizontalDivider()
    Spacer(modifier = Modifier.height(10.dp))
}