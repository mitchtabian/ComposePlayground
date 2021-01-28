package com.codingwithmitch.composeplayground

import android.os.Bundle
import android.util.Log
import androidx.activity.OnBackPressedDispatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.platform.AmbientViewModelStoreOwner
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

            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "home") {
                composable(route = "home") {
                    HomeScreen1(navController, it)
                }
                composable(route = "home2") {
                    HomeScreen2(navController, it)
                }
                composable(route = "home3") {
                    HomeScreen3(navController)
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























