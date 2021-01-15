package com.codingwithmitch.composeplayground.screens.profile

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel(){

    val name = mutableStateOf("")
}