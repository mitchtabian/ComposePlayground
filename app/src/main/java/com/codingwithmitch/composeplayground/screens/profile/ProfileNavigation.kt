package com.codingwithmitch.composeplayground.screens.profile

import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codingwithmitch.composeplayground.TAG

@Composable
fun ProfileNavigation(){
    val navController = rememberNavController()
    Log.d(TAG, "ProfileNavigation: profile nav controller: ${navController}")
    NavHost(navController = navController, startDestination = "profile1", route="profileStart") {
        composable("profile1") {
            ProfileScreen1(navController = navController)
        }
        composable("profile2") {
            ProfileScreen2()
        }
    }
}