package com.codingwithmitch.composeplayground.screens.home.home1

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel1
@Inject
constructor(): ViewModel(){

    val text = mutableStateOf("Home Screen 1")

    val query = mutableStateOf("")
}