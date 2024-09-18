package com.developbharat.facegate.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.developbharat.facegate.common.TabbedScreens


@Composable
fun TabbedBottomBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    NavigationBar {
        NavigationBarItem(
            selected = navBackStackEntry?.destination?.route?.contains(TabbedScreens.HomeScreen.toString()) == true,
            onClick = {
                navController.navigate(TabbedScreens.HomeScreen) {
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
            selected = navBackStackEntry?.destination?.route?.contains(TabbedScreens.VerificationScreen.toString()) == true,
            onClick = {
                navController.navigate(TabbedScreens.VerificationScreen) {
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
            selected = navBackStackEntry?.destination?.route?.contains(TabbedScreens.AttendanceScreen.toString()) == true,
            onClick = {
                navController.navigate(TabbedScreens.AttendanceScreen) {
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
            selected = navBackStackEntry?.destination?.route?.contains(TabbedScreens.SearchFaceScreen.toString()) == true,
            onClick = {
                navController.navigate(TabbedScreens.SearchFaceScreen) {
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
}