package com.codingwithmitch.composeplayground.screens.home

import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.codingwithmitch.composeplayground.TAG

@Composable
fun HomeNavigation(navController: NavHostController){
//    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
    when(currentRoute){
        "home" -> {
            HomeScreen1(navController = navController)
        }
        "home2" -> {
            HomeScreen2(navController = navController)
        }
        "home3" -> {
            HomeScreen3(navController = navController)
        }
    }

//    Log.d(TAG, "HomeNavigation: home nav controller: ${navController}")
//    NavHost(navController = navController, startDestination = "home1", route="homeStart") {
//        composable("home1") {
//            HomeScreen1(navController = navController)
//        }
//        composable("home2") {
//            HomeScreen2(navController = navController)
//        }
//        composable("home3") {
//            HomeScreen3(navController = navController)
//        }
//    }
}