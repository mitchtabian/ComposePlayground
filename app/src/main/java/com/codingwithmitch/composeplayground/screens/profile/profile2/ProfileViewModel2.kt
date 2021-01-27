package com.codingwithmitch.composeplayground.screens.profile.profile2

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel2
@Inject
constructor(): ViewModel(){

    val name = mutableStateOf("")
}