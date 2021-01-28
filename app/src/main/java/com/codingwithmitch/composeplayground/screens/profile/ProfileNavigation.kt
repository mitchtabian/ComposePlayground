package com.codingwithmitch.composeplayground.screens.profile

import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.codingwithmitch.composeplayground.TAG
import com.codingwithmitch.composeplayground.screens.home.HomeScreen1
import com.codingwithmitch.composeplayground.screens.home.HomeScreen2
import com.codingwithmitch.composeplayground.screens.home.HomeScreen3

@Composable
fun ProfileNavigation(navController: NavHostController){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
    when(currentRoute){
        "profile1" -> {
            ProfileScreen1(navController = navController)
        }
        "profile2" -> {
            ProfileScreen2()
        }
    }
}