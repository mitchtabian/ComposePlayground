package com.codingwithmitch.composeplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Scaffold
import androidx.compose.ui.platform.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codingwithmitch.composeplayground.components.BottomNav
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
                NavHost(navController = navController, startDestination = "home") {
                    composable(route = "home") {
                        HomeScreen()
                    }
                    composable(route = "profile") {
                        ProfileScreen()
                    }
                    composable(route = "settings") {
                        SettingsScreen()
                    }
                }
            }

        }
    }

}























