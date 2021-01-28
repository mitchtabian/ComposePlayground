package com.codingwithmitch.composeplayground.components

import android.util.Log
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import com.codingwithmitch.composeplayground.TAG
import com.codingwithmitch.composeplayground.navigation.Screen

val screens = listOf(
        Screen.Home,
        Screen.Profile,
        Screen.Settings,
)
@Composable
fun BottomNav(
        navController: NavController,
){
    BottomNavigation() {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
        screens.forEach { screen ->
            BottomNavigationItem(
                    icon = { Icon(screen.icon) },
                    selected = currentRoute == screen.route,
                    onClick = {
                        navController.navigate(screen.route) {
                            launchSingleTop = true
                        }
//                        for (item in navController.backStack) {
//                            Log.d(TAG, "BottomNav: ${item.destination}")
//                        }
                    }
            )
        }
    }
}











