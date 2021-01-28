package com.codingwithmitch.composeplayground

import android.os.Bundle
import android.util.Log
import androidx.activity.OnBackPressedDispatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.platform.setContent
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.*
import androidx.navigation.navOptions
import com.codingwithmitch.composeplayground.components.BottomNav
import com.codingwithmitch.composeplayground.screens.home.HomeNavigation
import com.codingwithmitch.composeplayground.screens.home.HomeScreen1
import com.codingwithmitch.composeplayground.screens.home.HomeScreen2
import com.codingwithmitch.composeplayground.screens.home.HomeScreen3
import com.codingwithmitch.composeplayground.screens.profile.ProfileNavigation
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

            val topNavController = rememberNavController()


            Log.d(TAG, "onCreate: top nav controller: ${topNavController}")

            Scaffold(
                bottomBar = {
                    BottomNav(navController = topNavController)
                }
            ) {
//                NavHost(navController = topNavController, startDestination = "home") {
                NavHost(navController = topNavController, startDestination = "homeRoute") {
                    navigation(startDestination = "home", route = "homeRoute"){
                        label = "HomeRoute"
                        composable(route = "home") {
                            label = "Home"
                            HomeScreen1(topNavController)
                        }
                        composable(route = "home2") {
                            label = "Home2"
                            HomeScreen2(topNavController)
                        }
                        composable(route = "home3") {
                            label = "Home3"
                            HomeScreen3(topNavController)
                        }
                    }
                    navigation(startDestination = "profile", route = "profileRoute"){
                        label = "ProfileRoute"
                        composable("profile") {
                            label = "Profile"
                            ProfileScreen1(topNavController)
                        }
                        composable("profile2") {
                            label = "Profile2"
                            ProfileScreen2()
                        }
                    }

                    composable("settings") {
                        SettingsScreen()
                    }
                }
            }

//            Providers(AmbientNavigation provides navigation) {
//                Scaffold(
//                    bottomBar = {
//                        BottomNav(navController = navController)
//                    }
//                ) {
//                    when(destination){
//
//                        Destination.Home -> {
//                            HomeScreen(navController)
//                        }
//
//                        Destination.Profile -> {
//                            ProfileScreen(navController)
//                        }
//
//                        Destination.Settings -> {
//                            SettingsScreen(navController)
//                        }
//                        else -> HomeScreen(navController) // app must exit from home destination
//                    }
//                }
//            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}























