package com.codingwithmitch.composeplayground.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.ambientOf
import androidx.compose.runtime.mutableStateOf

val AmbientNavigation = ambientOf<Navigation> { error("Navigation Error") }

class Navigation {

    val destination: MutableState<Destination?> = mutableStateOf(null)

    private val backStack = ArrayList<Destination>(listOf())

    fun navigate(newDestination: Destination, addToBackStack: Boolean){
        if(newDestination != destination.value){
            if(backStack.contains(newDestination)){
                backStack.remove(newDestination)
                backStack.add(newDestination)
            }
            else{
                if(addToBackStack){
                    backStack.add(newDestination)
                }
            }
            destination.value = newDestination
        }
    }

    // if the navigate has been handled, returned true
    fun onBackPressed(): Boolean {
        if(backStack.size > 1){
            val prev = backStack[backStack.size - 2]
            backStack.removeAt(backStack.size - 1)
            navigate(prev, false)
            return true
        }
        else if(backStack.size == 1){
            backStack.removeAt(backStack.size - 1)
            destination.value = null
            return true
        }
        return false
    }

}



















