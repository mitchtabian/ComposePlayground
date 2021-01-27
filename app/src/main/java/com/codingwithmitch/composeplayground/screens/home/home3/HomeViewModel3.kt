package com.codingwithmitch.composeplayground.screens.home.home3

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel3
@Inject
constructor(): ViewModel(){

    val text = mutableStateOf("Home Screen 3")

    val query = mutableStateOf("")
}