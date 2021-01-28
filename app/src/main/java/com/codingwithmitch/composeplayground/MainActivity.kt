package com.codingwithmitch.composeplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Scaffold
import androidx.compose.ui.platform.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.codingwithmitch.composeplayground.components.BottomNav
import com.codingwithmitch.composeplayground.navigation.Screen
import com.codingwithmitch.composeplayground.navigation.Screen.*
import com.codingwithmitch.composeplayground.screens.SettingsScreen


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            Scaffold(
                bottomBar = {
                    BottomNav(navController)
                }
            ) {
                NavHost(navController = navController, startDestination = Home.route) {
                    composable(route = Home.route) {
                        HomeScreen()
                    }
                    composable(route = Profile.route) {
                        ProfileScreen()
                    }
                    composable(route = Settings.route) {
                        SettingsScreen()
                    }
                }
            }

        }
    }

}























