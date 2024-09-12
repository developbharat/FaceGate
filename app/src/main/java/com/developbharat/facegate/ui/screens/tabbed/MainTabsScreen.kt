package com.developbharat.facegate.ui.screens.tabbed

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.developbharat.facegate.common.Screens
import com.developbharat.facegate.ui.screens.tabbed.attendance.AttendanceScreen
import com.developbharat.facegate.ui.screens.tabbed.home.HomeScreen
import com.developbharat.facegate.ui.screens.tabbed.searchface.SearchFaceScreen
import com.developbharat.facegate.ui.screens.tabbed.verification.VerificationScreen

@Composable
fun MainTabsScreen() {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = navBackStackEntry?.destination?.route?.contains(Screens.HomeScreen.toString()) == true,
                    onClick = {
                        navController.navigate(Screens.HomeScreen) {
                            // This keeps only 1 parent screen in back history
                            popUpTo(navController.graph.findStartDestination().id)
                            launchSingleTop = true
                        }
                    },
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    alwaysShowLabel = true
                )

                NavigationBarItem(
                    selected = navBackStackEntry?.destination?.route?.contains(Screens.VerificationScreen.toString()) == true,
                    onClick = {
                        navController.navigate(Screens.VerificationScreen) {
                            // This keeps only 1 parent screen in back history
                            popUpTo(navController.graph.findStartDestination().id)
                            launchSingleTop = true
                        }
                    },
                    icon = { Icon(Icons.Default.Verified, contentDescription = "Verification") },
                    label = { Text("Verification") },
                    alwaysShowLabel = true
                )


                NavigationBarItem(
                    selected = navBackStackEntry?.destination?.route?.contains(Screens.AttendanceScreen.toString()) == true,
                    onClick = {
                        navController.navigate(Screens.AttendanceScreen) {
                            // This keeps only 1 parent screen in back history
                            popUpTo(navController.graph.findStartDestination().id)
                            launchSingleTop = true
                        }
                    },
                    icon = { Icon(Icons.Default.Face, contentDescription = "Attendance") },
                    label = { Text("Attendance") },
                    alwaysShowLabel = true
                )

                NavigationBarItem(
                    selected = navBackStackEntry?.destination?.route?.contains(Screens.SearchFaceScreen.toString()) == true,
                    onClick = {
                        navController.navigate(Screens.SearchFaceScreen) {
                            // This keeps only 1 parent screen in back history
                            popUpTo(navController.graph.findStartDestination().id)
                            launchSingleTop = true
                        }
                    },
                    icon = { Icon(Icons.Default.Search, contentDescription = "Identification") },
                    label = { Text("Search Face") },
                    alwaysShowLabel = true
                )
            }
        }) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            NavHost(navController = navController, startDestination = Screens.HomeScreen) {
                composable<Screens.HomeScreen> { HomeScreen() }
                composable<Screens.VerificationScreen> { VerificationScreen() }
                composable<Screens.AttendanceScreen> { AttendanceScreen() }
                composable<Screens.SearchFaceScreen> { SearchFaceScreen() }
            }
        }
    }
}
