package com.codingwithmitch.composeplayground.navigation

sealed class Destination{
    
    object Home: Destination()
    
    object Profile: Destination()

    object Settings: Destination()
}