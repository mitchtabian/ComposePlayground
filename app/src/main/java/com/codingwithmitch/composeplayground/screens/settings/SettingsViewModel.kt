package com.codingwithmitch.composeplayground.screens.settings

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel(){

    val randomSetting1 = mutableStateOf(false)

    val randomSetting2 = mutableStateOf(false)

}