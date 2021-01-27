package com.codingwithmitch.composeplayground.screens.home.home2

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel2
@Inject
constructor(): ViewModel(){

    val text = mutableStateOf("Home Screen 2")

    val query = mutableStateOf("")
}