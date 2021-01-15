package com.codingwithmitch.composeplayground.navigation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.ambientOf
import androidx.compose.runtime.mutableStateOf
import com.codingwithmitch.composeplayground.TAG
import com.codingwithmitch.composeplayground.navigation.Destination.Home

val AmbientNavigation = ambientOf<Navigation> { error("Navigation Error") }

class Navigation(private val homeDestination: Destination) {

    val destination: MutableState<Destination> = mutableStateOf(homeDestination)

    private val backStack = ArrayList<Destination>(listOf(homeDestination))

    fun navigate(newDestination: Destination, addToBackStack: Boolean){
        if(newDestination != destination.value){
            if(backStack.contains(newDestination)){
                // exception for home destination (only if it is not the only destination currently in stack)
                if(
                    backStack.size > 1
                    && (newDestination::class.java == homeDestination::class.java)
                    && backStack.count { it == Home } < 2
                ){
                    backStack.add(newDestination)
                }
                else{
                    backStack.remove(newDestination)
                    backStack.add(newDestination)
                }
            }
            else{
                if(addToBackStack){
                    backStack.add(newDestination)
                }
            }
            printBackstack()
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
        return false
    }

    private fun printBackstack(){
        for((index, destination) in backStack.withIndex()){
            Log.d(TAG, "$index , ${destination::class.java}")
        }
    }

}



















