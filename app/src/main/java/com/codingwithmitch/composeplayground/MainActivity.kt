package com.codingwithmitch.composeplayground

import android.os.Bundle
import android.util.Log
import androidx.activity.OnBackPressedDispatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Scaffold
import androidx.compose.ui.platform.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codingwithmitch.composeplayground.components.BottomNav
import com.codingwithmitch.composeplayground.screens.home.HomeNavigation
import com.codingwithmitch.composeplayground.screens.profile.ProfileNavigation
import com.codingwithmitch.composeplayground.screens.settings.SettingsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(){

//    private val navigation by lazy {
//        (application as BaseApplication).navigation
//    }

//    interface Callback {
//        fun call()
//    }
//
//    lateinit var callback: Callback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

//            val destination = navigation.destination.value

            val topNavController = rememberNavController()

//            if(!::callback.isInitialized){
//                callback = object: Callback{
//                    override fun call() {
//                        for(destination in topNavController.graph){
////                            Log.d(TAG, "call: ${destination}")
//                        }
//                    }
//                }
//            }

            Log.d(TAG, "onCreate: top nav controller: ${topNavController}")

            Scaffold(
                bottomBar = {
                    BottomNav(navController = topNavController)
                }
            ) {
                NavHost(navController = topNavController, startDestination = "home") {
//                NavHost(navController = topNavController, startDestination = "homeStart") {
//                    navigation(startDestination = "nestedHome", route = "homeStart") {
//                        composable("nestedHome"){
//                            val navController = rememberNavController()
//                            NavHost(navController = navController, startDestination = "home1") {
//                                composable("home1") {
//                                    HomeScreen1(navController = navController)
//                                }
//                                composable("home2") {
//                                    HomeScreen2(navController = navController)
//                                }
//                                composable("home3") {
//                                    HomeScreen3(navController = navController)
//                                }
//                            }
//                        }
//                        composable("home1") {
//                            HomeScreen1(navController = rememberNavController())
//                        }
//                        composable("home2") {
//                            HomeScreen2(navController = rememberNavController())
//                        }
//                        composable("home3") {
//                            HomeScreen3(navController = rememberNavController())
//                        }
//
//                    }
                    composable("home") {
                        HomeNavigation()
                    }
                    composable("profile") {
                        ProfileNavigation()
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
//        if(::callback.isInitialized){
//            callback.call()
//        }
        super.onBackPressed()
    }

}























