package com.codingwithmitch.composeplayground.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.navigate

@Composable
fun BottomNav(
        navController: NavController
){
    BottomNavigation() {
        BottomNavigationItem(
            icon = {Icon(Icons.Default.Home)},
            selected = false,
            onClick = {
                navController.navigate("home"){
                    popUpTo = navController.graph.startDestination
                    launchSingleTop = true
                }
            }
        )
        BottomNavigationItem(
            icon = {Icon(Icons.Default.VerifiedUser)},
            selected = false,
            onClick = {
                navController.navigate("profile"){
                    popUpTo = navController.graph.startDestination
                    launchSingleTop = true
                }
            }
        )
        BottomNavigationItem(
            icon = {Icon(Icons.Default.Settings)},
            selected = false,
            onClick = {
                navController.navigate("settings"){
                    popUpTo = navController.graph.startDestination
                    launchSingleTop = true
                }
            }
        )
    }
}











