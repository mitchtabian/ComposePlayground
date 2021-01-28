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

                    // DOES THIS ALREADY EXIST IN THE BACKSTACK?
                    for (route in navController.graph) {
                        Log.d(TAG, "BottomNav: graph: ${route}")
                        Log.d(TAG, "BottomNav: ${route.label}")
                        Log.d(TAG, "BottomNav: ${route::class.java}")
                        if (route::class.java == NavGraph::class.java) {
                            Log.d(TAG, "BottomNav: GRAPH TYPE~!!")
                            for (inner in (route as NavGraph).asIterable()) {
                                Log.d(TAG, "BottomNav: destination: ${inner.label}")
//                                for (entry in navController.backStack.iterator()) {
//                                    if (navController.currentDestination?.label?.equals(entry.destination.label) == true) {
//                                        Log.d(TAG, "ENTRY: ${entry.destination.label}")
//                                    }
//                                }
                            }
                        }
                    }

                    Log.d(TAG, "BottomNav: CURRENT: ${navController.currentDestination?.label}")


//                    navController.graph.contains(navBackStackEntry?.destination?.id)


//                navController.navigate("homeStart")
//                navController.navigate("home"){
                    navController.navigate("home2") {
//                    popUpTo = navController.graph.startDestination
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
//                navController.navigate("profile"){
                navController.navigate("profileRoute"){
//                    popUpTo = navController.graph.startDestination
//                    launchSingleTop = true
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











