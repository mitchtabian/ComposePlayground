package com.codingwithmitch.composeplayground.screens.profile.profile1

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel1
@Inject
constructor(

): ViewModel(){

    val name = mutableStateOf("")
}