package com.codingwithmitch.composeplayground

import android.app.Application
import com.codingwithmitch.composeplayground.navigation.Navigation
import dagger.hilt.android.HiltAndroidApp

const val TAG = "AppDebug"

@HiltAndroidApp
class BaseApplication : Application(){

    val navigation = Navigation()

}