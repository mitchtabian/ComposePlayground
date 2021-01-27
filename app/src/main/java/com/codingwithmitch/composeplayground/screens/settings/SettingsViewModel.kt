package com.codingwithmitch.composeplayground.screens.settings

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel
@Inject
constructor(): ViewModel(){

    val randomSetting1 = mutableStateOf(false)

    val randomSetting2 = mutableStateOf(false)

}