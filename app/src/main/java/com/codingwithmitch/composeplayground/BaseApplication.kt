package com.codingwithmitch.composeplayground

import android.app.Application
import com.codingwithmitch.composeplayground.navigation.Destination
import com.codingwithmitch.composeplayground.navigation.Destination.*
import com.codingwithmitch.composeplayground.navigation.Navigation

const val TAG = "AppDebug"

class BaseApplication : Application(){

    val navigation = Navigation(Home)

}