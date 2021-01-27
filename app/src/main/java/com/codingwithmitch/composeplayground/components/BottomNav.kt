package com.codingwithmitch.composeplayground.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate // *** MUST MANUALLY IMPORT
import androidx.navigation.get

@Composable
fun BottomNav(navController: NavHostController){
    BottomNavigation() {
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Home) },
            selected = false,
            onClick = {
                navController.navigate("home"){
                    popUpTo = navController.graph.startDestination
                    launchSingleTop = true
                }
//                navController.navigate("nestedHome"){
//                    popUpTo = navController.graph.startDestination
//                    launchSingleTop = true
//                }
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
//    val navigation = AmbientNavigation.current
//    BottomNavigation() {
//        BottomNavigationItem(
//            icon = {Icon(Icons.Default.Home)},
//            selected = navigation.destination.value == Home || navigation.destination.value == null,
//            onClick = {
//                navigation.navigate(Home, true)
//            }
//        )
//        BottomNavigationItem(
//            icon = {Icon(Icons.Default.VerifiedUser)},
//            selected = navigation.destination.value == Profile,
//            onClick = {
//                navigation.navigate(Profile, true)
//            }
//        )
//        BottomNavigationItem(
//            icon = {Icon(Icons.Default.Settings)},
//            selected = navigation.destination.value == Settings,
//            onClick = {
//                navigation.navigate(Settings, true)
//            }
//        )
//    }
}











