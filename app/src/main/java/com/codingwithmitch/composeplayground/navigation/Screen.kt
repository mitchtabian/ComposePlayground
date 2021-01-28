package com.codingwithmitch.composeplayground.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Accessibility
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val icon: ImageVector) {
    object Home : Screen("home", Icons.Default.Home)
    object Profile : Screen("profile", Icons.Default.Accessibility)
    object Settings : Screen("settings", Icons.Default.Settings)
}