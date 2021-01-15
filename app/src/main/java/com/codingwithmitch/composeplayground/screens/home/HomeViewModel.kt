package com.codingwithmitch.composeplayground.screens.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel(){

    val text = mutableStateOf("Home Screen")

    val query = mutableStateOf("")
}