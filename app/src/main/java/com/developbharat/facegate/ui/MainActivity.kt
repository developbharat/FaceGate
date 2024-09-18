package com.developbharat.facegate.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.developbharat.facegate.common.Screens
import com.developbharat.facegate.common.TabbedScreens
import com.developbharat.facegate.ui.screens.batch.create.CreateBatchScreen
import com.developbharat.facegate.ui.screens.batch.set_active.SetActiveBatchScreen
import com.developbharat.facegate.ui.screens.tabbed.attendance.AttendanceScreen
import com.developbharat.facegate.ui.screens.tabbed.home.HomeScreen
import com.developbharat.facegate.ui.screens.tabbed.searchface.SearchFaceScreen
import com.developbharat.facegate.ui.screens.tabbed.verification.VerificationScreen
import com.developbharat.facegate.ui.theme.FaceGateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FaceGateTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = TabbedScreens.HomeScreen) {
                    // Tabbed screens
                    composable<TabbedScreens.HomeScreen> { HomeScreen(navController) }
                    composable<TabbedScreens.VerificationScreen> { VerificationScreen(navController) }
                    composable<TabbedScreens.AttendanceScreen> { AttendanceScreen(navController) }
                    composable<TabbedScreens.SearchFaceScreen> { SearchFaceScreen(navController) }

                    // Non Tabbed Screens
                    composable<Screens.SetActiveBatchScreen> { SetActiveBatchScreen() }
                    composable<Screens.CreateBatchScreen> { CreateBatchScreen() }
                }
            }
        }
    }
}

