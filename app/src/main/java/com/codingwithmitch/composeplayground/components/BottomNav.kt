package com.codingwithmitch.composeplayground.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.runtime.Composable
import com.codingwithmitch.composeplayground.navigation.AmbientNavigation
import com.codingwithmitch.composeplayground.navigation.Destination
import com.codingwithmitch.composeplayground.navigation.Destination.*

@Composable
fun BottomNav(){
    val navigation = AmbientNavigation.current
    BottomNavigation() {
        BottomNavigationItem(
            icon = {Icon(Icons.Default.Home)},
            selected = navigation.destination.value == Home,
            onClick = {
                navigation.navigate(Home, false)
            }
        )
        BottomNavigationItem(
            icon = {Icon(Icons.Default.VerifiedUser)},
            selected = navigation.destination.value == Profile,
            onClick = {
                navigation.navigate(Profile, true)
            }
        )
        BottomNavigationItem(
            icon = {Icon(Icons.Default.Settings)},
            selected = navigation.destination.value == Settings,
            onClick = {
                navigation.navigate(Settings, true)
            }
        )
    }
}











