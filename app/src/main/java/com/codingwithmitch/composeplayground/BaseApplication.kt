package com.codingwithmitch.composeplayground

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

const val TAG = "AppDebug"

@HiltAndroidApp
class BaseApplication : Application()

