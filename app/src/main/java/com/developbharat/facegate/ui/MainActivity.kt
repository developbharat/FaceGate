package com.developbharat.facegate.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.developbharat.facegate.ui.screens.tabbed.MainTabsScreen
import com.developbharat.facegate.ui.theme.FaceGateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FaceGateTheme {
                MainTabsScreen()
            }
        }
    }
}

