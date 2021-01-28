package com.codingwithmitch.composeplayground.screens.home

import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.codingwithmitch.composeplayground.TAG
import com.codingwithmitch.composeplayground.components.BottomNav

@Composable
fun HomeNavigation(
        navController: NavHostController,
        builder: NavGraphBuilder.() -> Unit
){
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
//    when(currentRoute){
//        "home" -> {
//            HomeScreen1(navController = navController)
//        }
//        "home2" -> {
//            HomeScreen2(navController = navController)
//        }
//        "home3" -> {
//            HomeScreen3(navController = navController)
//        }
//    }

}