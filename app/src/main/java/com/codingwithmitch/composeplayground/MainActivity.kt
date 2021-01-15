package com.codingwithmitch.composeplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Providers
import androidx.compose.ui.platform.setContent
import com.codingwithmitch.composeplayground.components.BottomNav
import com.codingwithmitch.composeplayground.navigation.AmbientNavigation
import com.codingwithmitch.composeplayground.navigation.Destination
import com.codingwithmitch.composeplayground.screens.SettingsScreen


class MainActivity : AppCompatActivity(){

    private val navigation by lazy {
        (application as BaseApplication).navigation
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            val destination = navigation.destination.value

            Providers(AmbientNavigation provides navigation) {
                Scaffold(
                    bottomBar = {
                        BottomNav()
                    }
                ) {
                    when(destination){

                        Destination.Home -> {
                            HomeScreen()
                        }

                        Destination.Profile -> {
                            ProfileScreen()
                        }

                        Destination.Settings -> {
                            SettingsScreen()
                        }
                        else -> HomeScreen() // app must exit from home destination
                    }
                }

            }
        }
    }

    override fun onBackPressed() {
        if(!navigation.onBackPressed()){
            super.onBackPressed()
        }
    }

}























