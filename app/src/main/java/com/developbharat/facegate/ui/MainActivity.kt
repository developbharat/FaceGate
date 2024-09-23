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
import com.developbharat.facegate.ui.screens.settings.SettingsScreen
import com.developbharat.facegate.ui.screens.tabbed.attendance.AttendanceScreen
import com.developbharat.facegate.ui.screens.tabbed.facematch.scan.ScanFaceMatchScreen
import com.developbharat.facegate.ui.screens.tabbed.facematch.select.SelectFaceMatchScreen
import com.developbharat.facegate.ui.screens.tabbed.home.HomeScreen
import com.developbharat.facegate.ui.screens.tabbed.searchface.SearchFaceScreen
import com.developbharat.facegate.ui.theme.FaceGateTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
                    composable<TabbedScreens.SelectFaceMatchScreen> { SelectFaceMatchScreen(navController) }
                    composable<TabbedScreens.ScanFaceMatchScreen>(
                        typeMap = TabbedScreens.ScanFaceMatchScreen.typeMap,
                    ) {
                        ScanFaceMatchScreen(navController)
                    }
                    composable<TabbedScreens.AttendanceScreen> { AttendanceScreen(navController) }
                    composable<TabbedScreens.SearchFaceScreen> { SearchFaceScreen(navController) }

                    // Non Tabbed Screens
                    composable<Screens.SettingsScreen> { SettingsScreen() }
                    composable<Screens.CreateBatchScreen> { CreateBatchScreen(navController) }
                }
            }
        }
    }
}