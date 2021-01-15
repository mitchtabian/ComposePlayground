package com.codingwithmitch.composeplayground.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.ambientOf
import androidx.compose.runtime.mutableStateOf
import com.codingwithmitch.composeplayground.navigation.Destination.Home

val AmbientNavigation = ambientOf<Navigation> { error("Navigation Error") }

class Navigation {

    val destination: MutableState<Destination> = mutableStateOf(Home)

    private val backStack = ArrayList<Destination>(listOf(Home))

    fun navigate(newDestination: Destination, addToBackStack: Boolean){
        if(addToBackStack){
            backStack.add(newDestination)
        }
        destination.value = newDestination
    }

    // if the navigate has been handled, returned true
    fun onBackPressed(): Boolean {
        if(backStack.size > 1){
            val current = backStack[backStack.size - 1]
            val prev = backStack[backStack.size - 2]
            backStack.remove(current)
            navigate(prev, false)
            return true
        }
        return false
    }
}



















