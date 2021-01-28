package com.codingwithmitch.composeplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codingwithmitch.composeplayground.screens.home.HomeScreen1
import com.codingwithmitch.composeplayground.screens.home.HomeScreen2
import com.codingwithmitch.composeplayground.screens.home.HomeScreen3
import com.codingwithmitch.composeplayground.screens.profile.ProfileScreen1
import com.codingwithmitch.composeplayground.screens.profile.ProfileScreen2
import com.codingwithmitch.composeplayground.screens.settings.SettingsScreen
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(){

//    private val navigation by lazy {
//        (application as BaseApplication).navigation
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

//            val destination = navigation.destination.value

            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "home") {
                composable(route = "home") {
                    HomeScreen1(navController)
                }
                composable(route = "home2") {
                    HomeScreen2(navController)
                }
                composable(route = "home3") {
                    HomeScreen3()
                }
                composable(route = "profile") {
                    ProfileScreen1(navController)
                }
                composable(route = "profile2") {
                    ProfileScreen2()
                }
                composable(route = "settings") {
                    SettingsScreen()
                }
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}























