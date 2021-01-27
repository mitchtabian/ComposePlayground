package com.codingwithmitch.composeplayground.screens.home

import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codingwithmitch.composeplayground.TAG

@Composable
fun HomeNavigation(){
    val navController = rememberNavController()
    Log.d(TAG, "HomeNavigation: home nav controller: ${navController}")
    NavHost(navController = navController, startDestination = "home1", route="homeStart") {
        composable("home1") {
            HomeScreen1(navController = navController)
        }
        composable("home2") {
            HomeScreen2(navController = navController)
        }
        composable("home3") {
            HomeScreen3(navController = navController)
        }
    }
}