package com.codingwithmitch.composeplayground.components

import android.util.Log
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate // *** MUST MANUALLY IMPORT
import com.codingwithmitch.composeplayground.TAG
import kotlin.collections.contains

@Composable
fun BottomNav(
        navController: NavHostController,
){
    BottomNavigation() {
        BottomNavigationItem(
                icon = { Icon(Icons.Default.Home) },
                selected = false,
                onClick = {
                    navController.navigate("home")
                }
        )
        BottomNavigationItem(
            icon = {Icon(Icons.Default.VerifiedUser)},
            selected = false,
            onClick = {
                navController.navigate("profile")
            }
        )
        BottomNavigationItem(
            icon = {Icon(Icons.Default.Settings)},
            selected = false,
            onClick = {
                navController.navigate("settings")
            }
        )
    }
}











